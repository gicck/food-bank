<template>
  <section class="py-6 text-gray-700 body-font relative">
    <div class="mt-10 sm:mt-0">
      <div class="md:grid md:grid-cols-3 md:gap-6">
        <div class="mt-5 md:mt-0 md:col-span-2">
          <FormulateForm
            v-model="delivery"
            name="deliveryForm"
            @submit="handleDeliverySubmit"
          >
            <div class="shadow overflow-hidden sm:rounded-md">
              <div class="px-4 py-5 bg-white sm:p-6">
                <h3 class="pb-5 text-lg font-medium leading-6 text-gray-900">
                  Crear Entrega
                </h3>
                <div class="grid grid-cols-6 gap-6">
                  <!-- <div class="col-span-6">
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
                  </div>

                  <div class="col-span-6">
                    <FormulateInput
                      type="select"
                      name="entityName"
                      label="Entidad Beneficiada"
                      validation="required"
                      placeholder="Selecciona una entidad de apoyo"
                      :options="{
                        sanRafael:
                          'Hogar de Ninos San Rafael - 50 beneficiarios',
                        aldeasSos: 'Aldeas S.O.S. - 150 beneficiarios',
                        patitasDescalzas:
                          'Albergue Comunitario Patitas Descalzas - 70 beneficiarios'
                      }"
                    />
                  </div>
                  <div class="col-span-6 sm:col-span-3">
                    <FormulateInput
                      type="text"
                      name="entityEmployeeName"
                      label="Nombre Encargado"
                      validation="required"
                      help="Nombre del encargado de la entidad beneficiaria"
                    />
                  </div>

                  <div class="col-span-6 sm:col-span-3">
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
                  </div> -->
                  <div class="col-span-6">
                    <FormulateInput
                      type="group"
                      name="stops"
                      label="Paradas"
                      help="Añade las paradas que seran parte de la entrega"
                      add-label="+ Añadir Parada"
                      validation="min:1,length"
                      v-model="stops"
                      :validation-messages="{
                        min: 'Se necesita al menos 1 parada'
                      }"
                      :repeatable="true"
                    >
                      <div class="grid grid-cols-6 gap-6">
                        <div class="col-span-6 sm:col-span-3">
                          <FormulateInput
                            type="text"
                            name="pickup"
                            label="Direccion Partida"
                            validation="required"
                          />
                        </div>
                        <div class="col-span-6 sm:col-span-3">
                          <FormulateInput
                            type="text"
                            name="destination"
                            label="Direccion Llegada"
                            validation="required"
                          />
                        </div>
                        <div class="col-span-6">
                          <FormulateInput
                            type="datetime-local"
                            name="pickupTime"
                            label="Hora Partida"
                            validation="required"
                          />
                        </div>
                        <div class="col-span-6">
                          <FormulateInput
                            type="datetime-local"
                            name="destinationTime"
                            label="Hora Partida"
                            validation="required"
                          />
                        </div>
                        <div class="col-span-6">
                          <FormulateInput
                            type="textarea"
                            name="instructions"
                            label="Instrucciones"
                            validation="max:50,length"
                          />
                        </div>
                        <!-- <div class="col-span-6 sm:col-span-3">
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
                        </div>
                        <div class="col-span-6 sm:col-span-3 lg:col-span-2">
                          <FormulateInput
                            name="quantity"
                            label="Cantidad"
                            type="number"
                            min="1"
                            step="0.01"
                            validation="required"
                          />
                        </div>
                        <div class="col-span-6 sm:col-span-3 lg:col-span-2">
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
                        </div>
                        <div class="col-span-6 sm:col-span-3 lg:col-span-2">
                          <FormulateInput
                            v-if="
                              items[index] &&
                                items[index].measureType === 'Unit'
                            "
                            name="capacity"
                            label="Cantidad por unidad"
                            type="number"
                            min="0"
                            step="0.01"
                            validation="required"
                            help="Cantidad de la capacidad en Kg/Lt."
                          />
                        </div>
                        <div class="col-span-6">
                          <FormulateInput
                            type="textarea"
                            name="itemDescription"
                            label="Observaciones"
                            validation="max:50,length"
                          />
                        </div>
                        <div class="col-span-6">
                          <p>
                            Cantidad Total: {{ total(items[index]) }} Kg./Lt.
                          </p>
                        </div> -->
                      </div>
                    </FormulateInput>
                  </div>
                </div>
              </div>
              <div class="col-span-6">
                <FormulateInput type="submit" value="Crear Order" />
              </div>
              <pre>{{ delivery }}</pre>
            </div>
          </FormulateForm>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  name: "DeliveryCreate",
  components: {},
  data() {
    return {
      delivery: {},
      stops: [{}]
    };
  }
};
</script>
