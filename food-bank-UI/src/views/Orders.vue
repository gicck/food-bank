<template>
  <section class="py-6 text-gray-700 body-font relative">
    <div class="mt-10 sm:mt-0">
      <div class="md:grid md:grid-cols-3 md:gap-6">
        <div class="mt-5 md:mt-0 md:col-span-2">
          <FormulateForm
            v-model="order"
            name="orderForm"
            @submit="handleOrderSubmit"
          >
            <div class="shadow overflow-hidden sm:rounded-md">
              <div class="px-4 py-5 bg-white sm:p-6">
                <h3 class="pb-5 text-lg font-medium leading-6 text-gray-900">
                  Crear Orden de Entrega
                </h3>
                <div class="grid grid-cols-6 gap-6">
                  <div class="col-span-6">
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
                    <!-- <label for="first_name" class="block text-sm font-medium leading-5 text-gray-700">First name</label>
                <input id="first_name" class="mt-1 form-input block w-full py-2 px-3 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:shadow-outline-blue focus:border-blue-300 transition duration-150 ease-in-out sm:text-sm sm:leading-5"> -->
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
                  <div class="col-span-6">
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
                      <div class="grid grid-cols-6 gap-6">
                        <div class="col-span-6 sm:col-span-3">
                          <FormulateInput
                            type="text"
                            name="name"
                            label="Nombre"
                            validation="required"
                          />
                        </div>
                        <div class="col-span-6 sm:col-span-3">
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
                        </div>
                      </div>
                    </FormulateInput>
                  </div>
                </div>
              </div>
              <div class="col-span-6">
                <FormulateInput type="submit" value="Crear Order" />
              </div>
              <!-- <pre>{{ order }}</pre> -->
            </div>
          </FormulateForm>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { dataService, dateService, exportService } from "../shared";

export default {
  name: "OrderCreate",
  props: {
    id: {
      type: Number,
      default: 0
    }
  },
  data() {
    return {
      order: {},
      items: [{}],
      handleOrderSubmit: async () => {
        const response = await dataService.createOrder(this.order);
        if (response) {
          alert(`Orden añadida.`);
          this.$formulate.reset("orderForm");
        } else {
          this.errors.push();
        }

        // this.$router.push({ name: "Home" });
      }
    };
  },
  async created() {
    this.order = await dataService.getOrder(this.id);
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
    },
    async deleteOrder() {
      await dataService.deleteOrder(this.order.id);
      this.$router.push({ name: "Home" });
    },
    cancelOrder() {
      this.$router.push({ name: "Home" });
    },
    exportOrder() {
      console.log("Exporting");
      exportService.printPDF(this.order);
    }
  },
  filters: {
    shortDate: date => {
      return dateService.getDateAndTime(date);
    },
    statusName: function(status) {
      let statusName = {
        CREATED: "Creado",
        PACKED: "Empacado",
        FINALIZED: "Finalizado",
        DISPATCHED: "Despachado",
        ACCEPTED: "Aceptado",
        RECEIVED: "Recbido"
      };

      return statusName[status];
    }
  }
};
</script>
