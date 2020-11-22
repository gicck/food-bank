<template>
  <section class="text-gray-700 body-font">
    <div class="container px-5 py-12 mx-auto">
      <div class="flex flex-col text-center w-full mb-20">
        <h2
          class="text-xs text-indigo-500 tracking-widest font-medium title-font mb-1"
        >
          FOODBANK
        </h2>
        <h1 class="sm:text-3xl text-2xl font-medium title-font text-gray-900">
          Beneficiarios
        </h1>
      </div>
      <div class="flex flex-wrap -m-10">
        <div class="p-4 md:w-1/2">
          <div class="border-t border-gray-300 p-6 text-center rounded-bl-lg">
            <router-link to="/recipientCreate" class="nav-link">
              <button
                class="flex items-center mt-auto text-white bg-indigo-500 border-0 py-2 px-4 w-full focus:outline-none hover:bg-indigo-600 rounded"
              >
                Crear Beneficiario
                <svg
                  fill="none"
                  stroke="currentColor"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  class="w-4 h-4 ml-auto"
                  viewBox="0 0 24 24"
                >
                  <path d="M5 12h14M12 5l7 7-7 7"></path>
                </svg>
              </button>
            </router-link>
          </div>
        </div>
      </div>
    </div>
    <section class="text-gray-700 body-font">
      <div class="container px-5 pr-12 mx-auto">
        <div class="flex flex-wrap w-full mb-8">
          <div class="w-full mb-6 lg:mb-0">
            <h1
              class="sm:text-3xl text-2xl font-medium title-font mb-2 text-gray-900"
            >
              Beneficiarios
            </h1>
            <div class="h-1 w-20 bg-indigo-500 rounded"></div>
          </div>
        </div>
      </div>
    </section>
  </section>
</template>

<script>
export default {};
</script>

<style></style>
