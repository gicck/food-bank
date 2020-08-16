<template>
  <FormulateForm 
    v-model="order"
    name="orderForm" 
    @submit="handleOrderSubmit">
    <FormulateInput 
      type="text" 
      name="orderId" 
      label="Id Orden" 
      validation="optional|matches:/^OE-[\d]{5}$/"
      :validation-messages="{
        matches: 'Debe seguir el patron OE-...'
      }"
      placeholder="OE-"
      help="El ID de la Orden (ej. OE-14414)"/>
    <FormulateInput 
      type="text" 
      name="employeeName" 
      label="Delegado del Banco" 
      validation="required"
      :validation-messages="{
        required: 'Este campo es requerido'
      }"
      help="Voluntario a cargo de la orden"/>
    <FormulateInput 
      type="select"
      name="entityName"
      label="Entidad Beneficiada" 
      validation="required"
      placeholder="Selecciona una entidad de apoyo"
       :options="{ 
        sanRafael: 'Hogar de Ninos San Rafael - 50 beneficiarios', 
        aldeasSos: 'Aldeas S.O.S. - 150 beneficiarios', 
        patitasDescalzas: 'Albergue Comunitario Patitas Descalzas - 70 beneficiarios'}"/>
    <FormulateInput 
      type="text" 
      name="entityEmployeeName" 
      label="Nombre Encargado" 
      validation="required"
      help="Nombre del encargado de la entidad beneficiaria"/>
    <FormulateInput 
      type="text" 
      name="entityEmployeePhone" 
      label="Telefono Encargado" 
      inputmode="numeric"
      pattern="[0-9]*"
      validation="optional|matches:/^[0-9-]+$/"
      :validation-messages="{
        matches:'El telefono solo debe contener digitos'}"
      help="Telefono del encargado de la entidad beneficiaria"/>
    <FormulateInput
      type="group"
      name="items"
      label="Items"
      help="Añade los items que seran parte de la orden"
      add-label="+ Añadir Item"
      validation="min:1,length"
      :validation-messages="{
        min:'Se necesita al menos 1 item'}"
      :repeatable="true">    
      <div class="item">
        <FormulateInput 
          name="quantity" 
          label="Cantidad" 
          type="number" 
          min="1" 
          validation="required|min:1" 
          :validation-messages="{
            min:'La cantidad debe ser al menos 1'}"/>
        <FormulateInput 
          name="type" 
          type="select" 
          label="Tipo" 
          validation="required" 
            :options="{ 
              cereals: 'Cereales y derivados',
              vegetables: 'Verduras y legumbres frescas',
              fruits: 'Frutas frescas',
              oilFat: 'Aceites y grasas',
              lactose: 'Productos lácteos',
              meat: 'Carnes, pescados y legumbres secas'}" />
        <FormulateInput 
          type="text" 
          name="name" 
          label="Nombre" 
          validation="required"/>
        <FormulateInput 
          name="capacity" 
          label="Capacidad" 
          type="number"
          min="1" 
          validation="optional|min:1" 
          :validation-messages="{
            min:'La cantidad debe ser al menos 1'}"
          help="Cantidad de la capacidad en Kg."/>
      </div>
    </FormulateInput>
    <FormulateInput type="submit" value="Crear Order" />  
  <pre>{{order}}</pre>
  </FormulateForm>
</template>
<script>
import axios from 'axios';

export default {
  name: "CreateOrder",
  props: {
    msg: String
  },
  data () {
    return { 
      order: {},
      errors: [],
      handleOrderSubmit: () => {
        axios.post(`http://jsonplaceholder.typicode.com/posts`, {
          body: this.order
        })
        .then(() => {
          alert(`Orden añadida.`);
          this.$formulate.reset('orderForm');          
        })
        .catch(e => {
          this.errors.push(e)});
      } 
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
</style>
