<template>
  <section class="py-6 text-gray-700 body-font relative">
    <div class="mt-10 sm:mt-0">
      <div class="md:grid md:grid-cols-3 md:gap-6">
        <div class="mt-5 md:mt-0 md:col-span-2">
          <FormulateForm
            v-model="donor"
            name="donorForm"
            @submit="handleDonorSubmit"
          >
            <div class="shadow overflow-hidden sm:rounded-md">
              <div class="px-4 py-5 bg-white sm:p-6">
                <h3 class="pb-5 text-lg font-medium leading-6 text-gray-900">
                  Crear Donador
                </h3>
                <div class="grid grid-cols-6 gap-6">
                  <div class="col-span-6 sm:col-span-3">
                    <FormulateInput
                      type="text"
                      name="donorName"
                      label="Entidad Donante"
                      validation="required"
                      :validation-messages="{
                        required: 'Este campo es requerido'
                      }"
                      help="Nombre de la entidad donante"
                    />
                  </div>                  
                  <div class="col-span-6 sm:col-span-3">
                    <FormulateInput
                      type="text"
                      name="personName"
                      label="Nombre Encargado"
                      validation="required"
                      help="Nombre del encargado de la entidad donante"
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
                      help="Telefono del encargado de la entidad donante"
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
                    <pre>{{ donor }}</pre>
                  </div> -->

                  <div class="col-span-6">
                    <FormulateInput type="submit" value="Crear Donador"/>
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
  name: "DonorCreate",
  components: {
    LocationSelectorMap
  },
  data() {
    return {
      donor: {},
      location: {
        position: { lat: -10.376246400377795, lng: -60.15699619613831 },
        address: ""
      },
      handleDonorSubmit: async () => {
        let realDonor = { ...this.donor };
        realDonor.latitude = this.location.position.lat;
        realDonor.longitude = this.location.position.lng;

        const response = await dataService.create('donors',realDonor);
        if (response) {
          alert(`Donante añadido.`);
          this.$formulate.reset("donorForm");
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
