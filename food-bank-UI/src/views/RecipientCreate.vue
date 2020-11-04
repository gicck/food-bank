<template>
  <section class="py-6 text-gray-700 body-font relative">
    <!-- <div class="mt-10 sm:mt-0">
      <div class="md:grid md:grid-cols-3 md:gap-6">
        <div class="mt-5 md:mt-0 md:col-span-2">
          <FormulateForm
            v-model="recipient"
            name="recipientForm"
            @submit="handleRecipientSubmit"
          >
            <div class="shadow overflow-hidden sm:rounded-md">
              <div class="px-4 py-5 bg-white sm:p-6">
                <h3 class="pb-5 text-lg font-medium leading-6 text-gray-900">
                  Crear Beneficiario
                </h3>
                <div class="grid grid-cols-6 gap-6">
                  <div class="col-span-6 sm:col-span-3">
                    <FormulateInput
                      type="text"
                      name="entityName"
                      label="Entidad Beneficiada"
                      validation="required"
                      :validation-messages="{
                        required: 'Este campo es requerido'
                      }"
                      help="Nombre de la entidad beneficiada"
                    />
                  </div>
                  <div class="col-span-6 sm:col-span-3">
                    <FormulateInput
                      type="number"
                      name="entityQuantity"
                      label="Cantidad Beneficiados"
                      validation="required"
                      :validation-messages="{
                        required: 'Este campo es requerido'
                      }"
                      help="Cantidad de beneficiados"
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
                  </div>                  
                </div>
              </div>
              <div class="col-span-6">
                <FormulateInput type="submit" value="Crear Order" />
              </div>
            </div>
          </FormulateForm>
        </div>
      </div>
    </div> -->
    <!-- <div class="col-span-6"> -->
      <Map @setLocation="setLocation"/>
                    
  </section>
</template>

<script>
import Map from "@/components/map";

export default {
    name: "RecipientCreate",
    components: {        
        Map
    },   
    data() {
    return {        
        recipient: {}, 
        selectedLocation: undefined,     
        handleRecipientSubmit: async () => {        
        }
      };
    },
    methods: {      
      setLocation(location) {        
        this.selectedLocation = location;
      },
    }  
}
</script>

<style>

</style>