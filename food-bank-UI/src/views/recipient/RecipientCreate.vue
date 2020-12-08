<template>
  <section class="py-6 text-gray-700 body-font relative">
    <div class="mt-10 sm:mt-0">
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
                      name="recipientName"
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
                      name="recipientQuantity"
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
                      name="personName"
                      label="Nombre Encargado"
                      validation="required"
                      help="Nombre del encargado de la entidad beneficiaria"
                    />
                  </div>
                  <div class="col-span-6 sm:col-span-3">
                    <FormulateInput
                      type="text"
                      name="phoneNumber"
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
                  <div class="col-span-6">
                    <FormulateInput
                      type="text"
                      name="address"
                      label="Direccion"
                      validation="required"
                      :validation-messages="{
                        required: 'Este campo es requerido'
                      }"
                      help="Direccion de recojo de la entidad"
                    />
                  </div>
                  <div class="col-span-6">
                    <!-- {{location}} -->
                    <!-- <span class="block text-sm font-medium leading-5 text-gray-700">Direccion</span> -->
                    <location-selector-map v-model="location" />
                  </div>
                  <!-- <div class="col-span-6">
                    <pre>{{ location }}</pre>
                  </div>
                  <div class="col-span-6">
                    <pre>{{ recipient }}</pre>
                  </div> -->

                  <div class="col-span-6">
                    <FormulateInput type="submit" value="Crear Beneficiario" />
                  </div>
                </div>
              </div>
            </div>
          </FormulateForm>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import LocationSelectorMap from "../../components/LocationSelectorMap";
import { dataService } from "../../shared";

export default {
  name: "RecipientCreate",
  components: {
    LocationSelectorMap
  },
  data() {
    return {
      recipient: {},
      location: {
        position: { lat: -10.376246400377795, lng: -60.15699619613831 },
        address: ""
      },
      handleRecipientSubmit: async () => {
        let realRecipient = { ...this.recipient };
        realRecipient.latitude = this.location.position.lat;
        realRecipient.longitude = this.location.position.lng;

        const response = await dataService.createRecipient(realRecipient);
        if (response) {
          alert(`Beneficiario añadido.`);
          this.$formulate.reset("recipientForm");
        } else {
          this.errors.push();
        }
      }
    };
  },
  methods: {}
};
</script>

<style></style>
