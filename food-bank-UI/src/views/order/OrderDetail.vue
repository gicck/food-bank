<template>
  <div>
    <h2 class="my-6 text-2xl font-semibold text-gray-700 dark:text-gray-200">
      Orden de Entrega
    </h2>
    <!-- Reporte -->
    <a
      class="flex items-center justify-between p-4 mb-8 text-sm font-semibold text-purple-100 bg-indigo-500 rounded-lg shadow-md focus:outline-none focus:shadow-outline-purple"
    >
      <div class="flex items-center">
        <svg class="w-5 h-5 mr-2" fill="currentColor" viewBox="0 0 20 20">
          <path
            d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"
          ></path>
        </svg>
        <span>Reporte Orden</span>
      </div>
      <span @click="exportOrder()">Exportar &RightArrow;</span>
    </a>
    <!-- Responsive cards -->
    <h4 class="mb-4 text-lg font-semibold text-gray-600 dark:text-gray-300">
      Estado
    </h4>
    <!-- Cards -->
    <div class="grid gap-6 mb-8 md:grid-cols-2 xl:grid-cols-4">
      <!-- Card -->
      <div
        class="flex items-center p-4 bg-white rounded-lg shadow-xs dark:bg-gray-800"
        v-if="order.createdDate"
      >
        <div
          class="p-3 mr-4 text-orange-500 bg-orange-100 rounded-full dark:text-orange-100 dark:bg-orange-500"
        >
          <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20">
            <path
              d="M13 6a3 3 0 11-6 0 3 3 0 016 0zM18 8a2 2 0 11-4 0 2 2 0 014 0zM14 15a4 4 0 00-8 0v3h8v-3zM6 8a2 2 0 11-4 0 2 2 0 014 0zM16 18v-3a5.972 5.972 0 00-.75-2.906A3.005 3.005 0 0119 15v3h-3zM4.75 12.094A5.973 5.973 0 004 15v3H1v-3a3 3 0 013.75-2.906z"
            ></path>
          </svg>
        </div>
        <div>
          <p class="mb-2 text-sm font-medium text-gray-600 dark:text-gray-400">
            Creada en:
          </p>
          <p class="text-lg font-semibold text-gray-700 dark:text-gray-200">
            {{ order.createdDate | shortDate }}
          </p>
        </div>
      </div>
      <!-- Card -->
      <div
        class="flex items-center p-4 bg-white rounded-lg shadow-xs dark:bg-gray-800"
        v-if="order.acceptedDate"
      >
        <div
          class="p-3 mr-4 text-green-500 bg-green-100 rounded-full dark:text-green-100 dark:bg-green-500"
        >
          <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20">
            <path
              fill-rule="evenodd"
              d="M4 4a2 2 0 00-2 2v4a2 2 0 002 2V6h10a2 2 0 00-2-2H4zm2 6a2 2 0 012-2h8a2 2 0 012 2v4a2 2 0 01-2 2H8a2 2 0 01-2-2v-4zm6 4a2 2 0 100-4 2 2 0 000 4z"
              clip-rule="evenodd"
            ></path>
          </svg>
        </div>
        <div>
          <p class="mb-2 text-sm font-medium text-gray-600 dark:text-gray-400">
            Aceptada en:
          </p>
          <p class="text-lg font-semibold text-gray-700 dark:text-gray-200">
            {{ order.acceptedDate | shortDate }}
          </p>
        </div>
      </div>
      <!-- Card -->
      <div
        class="flex items-center p-4 bg-white rounded-lg shadow-xs dark:bg-gray-800"
        v-if="order.packedDate"
      >
        <div
          class="p-3 mr-4 text-blue-500 bg-blue-100 rounded-full dark:text-blue-100 dark:bg-blue-500"
        >
          <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20">
            <path
              d="M3 1a1 1 0 000 2h1.22l.305 1.222a.997.997 0 00.01.042l1.358 5.43-.893.892C3.74 11.846 4.632 14 6.414 14H15a1 1 0 000-2H6.414l1-1H14a1 1 0 00.894-.553l3-6A1 1 0 0017 3H6.28l-.31-1.243A1 1 0 005 1H3zM16 16.5a1.5 1.5 0 11-3 0 1.5 1.5 0 013 0zM6.5 18a1.5 1.5 0 100-3 1.5 1.5 0 000 3z"
            ></path>
          </svg>
        </div>
        <div>
          <p class="mb-2 text-sm font-medium text-gray-600 dark:text-gray-400">
            Emapacada en:
          </p>
          <p class="text-lg font-semibold text-gray-700 dark:text-gray-200">
            {{ order.packedDate | shortDate }}
          </p>
        </div>
      </div>
      <!-- Card -->
      <div
        class="flex items-center p-4 bg-white rounded-lg shadow-xs dark:bg-gray-800"
        v-if="order.dispatchedDate"
      >
        <div
          class="p-3 mr-4 text-teal-500 bg-teal-100 rounded-full dark:text-teal-100 dark:bg-teal-500"
        >
          <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20">
            <path
              fill-rule="evenodd"
              d="M18 5v8a2 2 0 01-2 2h-5l-5 4v-4H4a2 2 0 01-2-2V5a2 2 0 012-2h12a2 2 0 012 2zM7 8H5v2h2V8zm2 0h2v2H9V8zm6 0h-2v2h2V8z"
              clip-rule="evenodd"
            ></path>
          </svg>
        </div>
        <div>
          <p class="mb-2 text-sm font-medium text-gray-600 dark:text-gray-400">
            Despachada en:
          </p>
          <p class="text-lg font-semibold text-gray-700 dark:text-gray-200">
            {{ order.dispatchedDate | shortDate }}
          </p>
        </div>
      </div>
      <!-- Card -->
      <div
        class="flex items-center p-4 bg-white rounded-lg shadow-xs dark:bg-gray-800"
        v-if="order.receivedDate"
      >
        <div
          class="p-3 mr-4 text-teal-500 bg-teal-100 rounded-full dark:text-teal-100 dark:bg-teal-500"
        >
          <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20">
            <path
              fill-rule="evenodd"
              d="M18 5v8a2 2 0 01-2 2h-5l-5 4v-4H4a2 2 0 01-2-2V5a2 2 0 012-2h12a2 2 0 012 2zM7 8H5v2h2V8zm2 0h2v2H9V8zm6 0h-2v2h2V8z"
              clip-rule="evenodd"
            ></path>
          </svg>
        </div>
        <div>
          <p class="mb-2 text-sm font-medium text-gray-600 dark:text-gray-400">
            Recibida en:
          </p>
          <p class="text-lg font-semibold text-gray-700 dark:text-gray-200">
            {{ order.receivedDate | shortDate }}
          </p>
        </div>
      </div>
      <!-- Card -->
      <div
        class="flex items-center p-4 bg-white rounded-lg shadow-xs dark:bg-gray-800"
        v-if="order.finalizedDate"
      >
        <div
          class="p-3 mr-4 text-teal-500 bg-teal-100 rounded-full dark:text-teal-100 dark:bg-teal-500"
        >
          <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20">
            <path
              fill-rule="evenodd"
              d="M18 5v8a2 2 0 01-2 2h-5l-5 4v-4H4a2 2 0 01-2-2V5a2 2 0 012-2h12a2 2 0 012 2zM7 8H5v2h2V8zm2 0h2v2H9V8zm6 0h-2v2h2V8z"
              clip-rule="evenodd"
            ></path>
          </svg>
        </div>
        <div>
          <p class="mb-2 text-sm font-medium text-gray-600 dark:text-gray-400">
            Finalizada en:
          </p>
          <p class="text-lg font-semibold text-gray-700 dark:text-gray-200">
            {{ order.finalizedDate | shortDate }}
          </p>
        </div>
      </div>
    </div>

    <FormulateForm v-model="order" name="orderForm" @submit="handleOrderSubmit">
      <FormulateInput
        type="select"
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
import { dataService, dateService, exportService } from "../../shared";

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
      items: [{}],
      handleOrderSubmit: async () => {
        await dataService.updateOrder(this.order);
        this.$router.push({ name: "Home" });
      }
    };
  },
  async created() {
    console.log(this.id);
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

<style></style>
