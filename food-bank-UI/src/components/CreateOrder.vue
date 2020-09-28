<template>
  <!-- <div> -->
  <FormulateForm v-model="order" name="orderForm" @submit="handleOrderSubmit">
    <FormulateInput
      type="text"
      name="employeeName"
      label="Delegado del Banco"
      validation="required"
      :validation-messages="{
        required: 'Este campo es requerido'
      }"
      help="Voluntario a cargo de la orden"
    />
    <FormulateInput
      type="select"
      name="entityName"
      label="Entidad Beneficiada"
      validation="required"
      placeholder="Selecciona una entidad de apoyo"
      :options="{
        sanRafael: 'Hogar de Ninos San Rafael - 50 beneficiarios',
        aldeasSos: 'Aldeas S.O.S. - 150 beneficiarios',
        patitasDescalzas:
          'Albergue Comunitario Patitas Descalzas - 70 beneficiarios'
      }"
    />
    <FormulateInput
      type="text"
      name="entityEmployeeName"
      label="Nombre Encargado"
      validation="required"
      help="Nombre del encargado de la entidad beneficiaria"
    />
    <FormulateInput
      type="text"
      name="entityEmployeePhone"
      label="Telefono Encargado"
      inputmode="numeric"
      pattern="[0-9]*"
      validation="optional|matches:/^[0-9-]+$/"
      :validation-messages="{
        matches: 'El telefono solo debe contener digitos'
      }"
      help="Telefono del encargado de la entidad beneficiaria"
    />
    <FormulateInput
      type="group"
      name="items"
      label="Items"
      help="Añade los items que seran parte de la orden"
      add-label="+ Añadir Item"
      validation="min:1,length"
      v-model="items"
      #default="{index}"
      :validation-messages="{
        min: 'Se necesita al menos 1 item'
      }"
      :repeatable="true"
    >
      <div class="item">
        <FormulateInput
          type="text"
          name="name"
          label="Nombre"
          validation="required"
        />
        <FormulateInput
          name="itemType"
          type="select"
          label="Tipo"
          validation="required"
          :options="{
            CEREALS: 'Cereales y derivados',
            VEGETABLES: 'Verduras y legumbres frescas',
            FRUITS: 'Frutas frescas',
            FAT: 'Aceites y grasas',
            LACTOSE: 'Productos lácteos',
            MEAT: 'Carnes, pescados y legumbres secas'
          }"
        />
        <FormulateInput
          name="quantity"
          label="Cantidad"
          type="number"
          min="1"
          step="0.01"
          validation="required"
        />
        <FormulateInput
          name="measureType"
          type="select"
          label="Tipo"
          validation="required"
          value="1"
          :options="{
            Lt: 'Litros',
            Kg: 'Kilogramos',
            Unit: 'Unidades'
          }"
        />
        <FormulateInput
          v-if="items[index] && items[index].measureType === 'Unit'"
          name="capacity"
          label="Cantidad por unidad"
          type="number"
          min="0"
          step="0.01"
          validation="required"
          help="Cantidad de la capacidad en Kg/Lt."
        />
        <div>
          <p>Cantidad Total: {{ total(items[index]) }} Kg./Lt.</p>
        </div>
        <FormulateInput
          type="textarea"
          name="itemDescription"
          label="Observaciones"
          validation="max:50,length"
        />
      </div>
    </FormulateInput>
    <FormulateInput type="submit" value="Crear Order" />
    <!-- <FormulateInput type="submit" value="Crear Order" /> -->
    <pre>{{ order }}</pre>
  </FormulateForm>
</template>

<script>
import axios from "axios";

export default {
  name: "CreateOrder",
  props: {
    msg: String
  },
  methods: {
    total: function(currentItem) {
      var total = 0;
      if (currentItem) {
        if (currentItem.measureType == "Unit") {
          total = currentItem.quantity * currentItem.capacity;
          currentItem.total = total;
        } else {
          total = currentItem.quantity;
          currentItem.total = total;
        }
      }
      return total;
    }
  },
  data() {
    return {
      order: {},
      items: [{}],
      errors: [],
      handleOrderSubmit: () => {
        axios
          .post(`http://localhost:9090/orders`, this.order)
          .then(() => {
            alert(`Orden añadida.`);
            this.$formulate.reset("orderForm");
          })
          .catch(e => {
            this.errors.push(e);
          });
      }
    };
  }
};
</script>
