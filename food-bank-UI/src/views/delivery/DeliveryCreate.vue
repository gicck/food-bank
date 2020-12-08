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
                  <div class="col-span-6">
                    <FormulateInput
                      type="text"
                      name="description"
                      label="Descripcion"
                      help="Descripcion de la entrega"
                    />
                  </div>
                  <div class="col-span-6">
                    <FormulateInput
                      type="select"
                      name="orderId"
                      label="Orden"
                      validation="required"
                      placeholder="Selecciona una orden"
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
                  </div>
                  <div class="col-span-6 sm:col-span-3">
                    <h3
                      class="pb-1 text-base font-medium leading-6 text-gray-900"
                    >
                      Partida
                    </h3>
                    <FormulateInput type="group" name="start">
                      <FormulateInput
                        type="text"
                        name="pickup"
                        label="Direccion Partida"
                        validation="required"
                      />
                      <FormulateInput
                        type="datetime-local"
                        name="time"
                        label="Hora de partida"
                        validation="required"
                      />
                    </FormulateInput>
                  </div>
                  <div class="col-span-6 sm:col-span-3">
                    <h3
                      class="pb-1 text-base font-medium leading-6 text-gray-900"
                    >
                      Llegada
                    </h3>
                    <FormulateInput type="group" name="finish">
                      <tr>
                        <td
                          v-for="recipient in recipients"
                          v-bind:key="recipient.id"
                          v-on:click="currentRecipient = recipient"
                          class="px-4 py-3"
                        >
                          <span
                            class="bg-gray-200 inline-flex py-3 px-5 rounded-lg items-center hover:bg-gray-300 focus:outline-none"
                            v-bind:class="[
                              'tab-button',
                              { active: currentRecipient === recipient }
                            ]"
                          >
                            <span
                              class="ml-1 items-start flex-col leading-none"
                            >
                              <span class="title-font font-medium">{{
                                recipient.label
                              }}</span>
                            </span>
                          </span>
                        </td>
                      </tr>

                      <FormulateInput
                        type="datetime-local"
                        name="time"
                        label="Hora de llegada"
                        validation="required"
                      />
                    </FormulateInput>
                  </div>
                  <div class="col-span-6">
                    <FormulateInput
                      type="textarea"
                      name="instructions"
                      label="Instrucciones"
                      validation="max:50,length"
                    />
                  </div>
                </div>
              </div>
              <div class="col-span-6">
                <FormulateInput type="submit" value="Crear Entrega" />
              </div>
              <pre>{{ currentRecipient }}</pre>
              <pre>{{ delivery }}</pre>
            </div>
          </FormulateForm>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { dataService } from "../../shared";

export default {
  name: "DeliveryCreate",
  components: {},
  data() {
    return {
      delivery: {},
      currentRecipient: {},
      errors: [],
      recipients: [],
      stops: [{}],
      handleDeliverySubmit: async () => {
        let realDelivery = {
          description: this.delivery.description,
          fromAddress: this.delivery.start[0].pickup,
          pickupTime: this.delivery.start[0].time,
          toName: this.delivery.entityEmployeeName,
          toPhone: this.delivery.entityEmployeePhone,
          arrivalTime: this.delivery.finish[0].time,
          instructions: this.delivery.instructions
        };

        realDelivery.recipient = { id: this.currentRecipient.value };
        realDelivery.order = { id: 2 };

        console.log(realDelivery);

        const response = await dataService.create("deliveries", realDelivery);

        if (response) {
          alert(`Entrega añadida.`);
          this.$formulate.reset("deliveryForm");
        } else {
          this.errors.push();
        }
      }
    };
  },
  async created() {
    let recipientsResponse = await dataService.getMany("recipients");
    this.recipients = recipientsResponse.map(recipient => {
      return {
        value: recipient.id,
        label: `${recipient.recipientName} - ${recipient.recipientQuantity}.`
      };
    });
  }
};
</script>
<style>
.tab-button.active {
  --bg-opacity: 1;
  background-color: rgba(226, 232, 240, var(--bg-opacity));
}
</style>
