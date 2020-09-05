<template>
  <div>
    <h2 class="my-6 text-2xl font-semibold text-gray-700 dark:text-gray-200">Orden de Entrega</h2>
    <FormulateForm v-model="order" name="orderForm" @submit="handleOrderSubmit">
      <FormulateInput
        type="radio"
        label="Estado de la Orden"
        name="state"
        :options="{
          ACCEPTED: 'Aceptada',
          PACKED: 'Empacada',
          DISPATCHED: 'Despachada',
          RECEIVED: 'Recibida',
          FINALIZED: 'Finalizada'
        }"
        help="Seleccione el estado de la Orden."
      />
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
        :validation-messages="{
          min: 'Se necesita al menos 1 item'
        }"
        :repeatable="true"
      >
        <div class="item">
          <FormulateInput
            name="quantity"
            label="Cantidad"
            type="number"
            min="1"
            validation="required|min:1"
            :validation-messages="{
              min: 'La cantidad debe ser al menos 1'
            }"
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
          <FormulateInput type="text" name="name" label="Nombre" validation="required" />
          <FormulateInput
            name="capacity"
            label="Capacidad"
            type="number"
            min="1"
            validation="optional|min:1"
            :validation-messages="{
              min: 'La cantidad debe ser al menos 1'
            }"
            help="Cantidad de la capacidad en Kg."
          />
        </div>
      </FormulateInput>
      <div class="display: flex">
        <FormulateInput type="submit" value="Guardar" />
        <button
          class="px-3 py-1 text-sm ml-2 font-medium leading-5 text-white transition-colors duration-150 bg-gray-600 border border-transparent rounded-lg active:bg-gray-600 hover:bg-gray-700 focus:outline-none focus:shadow-outline-gray"
          @click="cancelOrder()"
        >
          <span>Cancelar</span>
        </button>
      </div>
    </FormulateForm>
    <button
      class="px-4 py-2 text-sm mt-2 font-medium leading-5 text-white transition-colors duration-150 bg-red-600 border border-transparent rounded-lg active:bg-red-600 hover:bg-red-700 focus:outline-none focus:shadow-outline-red"
      @click="deleteOrder()"
    >
      <span>Eliminar Orden</span>
    </button>
  </div>
</template>

<script>
import { dataService } from "../shared";

export default {
  name: "OrderDetail",
  props: {
    id: {
      type: Number,
      default: 0
    }
  },
  data() {
    return {
      order: {},
      handleOrderSubmit: async e => {
        console.log("asdasd", e);
        await dataService.updateOrder(this.order);
        this.$router.push({ name: "Home" });
      }
    };
  },
  async created() {
    this.order = await dataService.getOrder(this.id);
  },
  methods: {
    async deleteOrder() {
      await dataService.deleteOrder(this.order.id);
      this.$router.push({ name: "Home" });
    },
    cancelOrder() {
      this.$router.push({ name: "Home" });
    }
  }
};
</script>

<style></style>
