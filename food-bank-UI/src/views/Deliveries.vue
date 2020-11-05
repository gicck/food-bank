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
          Entregas
        </h1>
      </div>
      <div class="flex flex-wrap -m-10">
        <div class="p-4 md:w-1/2">
          <div class="border-t border-gray-300 p-6 text-center rounded-bl-lg">
            <router-link to="/deliveryCreate" class="nav-link">
              <button
                class="flex items-center mt-auto text-white bg-indigo-500 border-0 py-2 px-4 w-full focus:outline-none hover:bg-indigo-600 rounded"
              >
                Crear Entrega
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
        <div class="p-4 md:w-1/2">
          <div class="border-t border-gray-300 p-6 text-center rounded-bl-lg">
            <button
              class="flex items-center mt-auto text-white bg-indigo-500 border-0 py-2 px-4 w-full focus:outline-none hover:bg-indigo-600 rounded"
            >
              Reportes
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
              Entregas por asignar
            </h1>
            <div class="h-1 w-20 bg-indigo-500 rounded"></div>
          </div>
        </div>
        <section class="text-gray-700 body-font">
          <div class="flex flex-wrap -m-4">
            <div class="p-4 lg:w-1/3">
              <div
                class="h-full bg-gray-200 px-8 pt-16 pb-24 rounded-lg overflow-hidden text-center relative"
              >
                <h2
                  class="tracking-widest text-xs title-font font-medium text-gray-500 mb-1"
                >
                  ENTREGA
                </h2>
                <h1
                  class="title-font sm:text-2xl text-xl font-medium text-gray-900 mb-3"
                >
                  EN-5692
                </h1>
                <p class="leading-relaxed mb-3">
                  Av. Heroinas #1331 - Blanco Galindo Km.10. <br />
                  Entrega programada del mes de Octubre.
                </p>
                <a class="text-indigo-500 inline-flex items-center"
                  >Asignar Entrega
                  <svg
                    class="w-4 h-4 ml-2"
                    viewBox="0 0 24 24"
                    stroke="currentColor"
                    stroke-width="2"
                    fill="none"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  >
                    <path d="M5 12h14"></path>
                    <path d="M12 5l7 7-7 7"></path>
                  </svg>
                </a>
                <div
                  class="text-center mt-2 leading-none flex justify-center absolute bottom-0 left-0 w-full py-4"
                >
                  <span
                    class="text-gray-600 mr-3 inline-flex items-center leading-none text-sm pr-3 py-1 border-r-2 border-gray-300"
                  >
                    <svg
                      class="w-4 h-4 mr-3"
                      fill="none"
                      stroke="currentColor"
                      viewBox="0 0 24 24"
                    >
                      <path
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        stroke-width="2"
                        d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z"
                      ></path>
                    </svg>
                    10-11-2020
                  </span>
                  <span
                    class="text-gray-600 inline-flex items-center leading-none text-sm"
                  >
                    3:00 PM
                  </span>
                </div>
              </div>
            </div>
            <div class="p-4 lg:w-1/3">
              <div
                class="h-full bg-gray-200 px-8 pt-16 pb-24 rounded-lg overflow-hidden text-center relative"
              >
                <h2
                  class="tracking-widest text-xs title-font font-medium text-gray-500 mb-1"
                >
                  ENTREGA
                </h2>
                <h1
                  class="title-font sm:text-2xl text-xl font-medium text-gray-900 mb-3"
                >
                  EN-5692
                </h1>
                <p class="leading-relaxed mb-3">
                  Av. Heroinas #1331 - Blanco Galindo Km.10. <br />
                  Entrega programada del mes de Octubre.
                </p>
                <a class="text-indigo-500 inline-flex items-center"
                  >Asignar Entrega
                  <svg
                    class="w-4 h-4 ml-2"
                    viewBox="0 0 24 24"
                    stroke="currentColor"
                    stroke-width="2"
                    fill="none"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  >
                    <path d="M5 12h14"></path>
                    <path d="M12 5l7 7-7 7"></path>
                  </svg>
                </a>
                <div
                  class="text-center mt-2 leading-none flex justify-center absolute bottom-0 left-0 w-full py-4"
                >
                  <span
                    class="text-gray-600 mr-3 inline-flex items-center leading-none text-sm pr-3 py-1 border-r-2 border-gray-300"
                  >
                    <svg
                      class="w-4 h-4 mr-3"
                      fill="none"
                      stroke="currentColor"
                      viewBox="0 0 24 24"
                    >
                      <path
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        stroke-width="2"
                        d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z"
                      ></path>
                    </svg>
                    10-11-2020
                  </span>
                  <span
                    class="text-gray-600 inline-flex items-center leading-none text-sm"
                  >
                    3:00 PM
                  </span>
                </div>
              </div>
            </div>
            <div class="p-4 lg:w-1/3">
              <div
                class="h-full bg-gray-200 px-8 pt-16 pb-24 rounded-lg overflow-hidden text-center relative"
              >
                <h2
                  class="tracking-widest text-xs title-font font-medium text-gray-500 mb-1"
                >
                  ENTREGA
                </h2>
                <h1
                  class="title-font sm:text-2xl text-xl font-medium text-gray-900 mb-3"
                >
                  EN-5692
                </h1>
                <p class="leading-relaxed mb-3">
                  Av. Heroinas #1331 - Blanco Galindo Km.10. <br />
                  Entrega programada del mes de Octubre.
                </p>
                <a class="text-indigo-500 inline-flex items-center"
                  >Asignar Entrega
                  <svg
                    class="w-4 h-4 ml-2"
                    viewBox="0 0 24 24"
                    stroke="currentColor"
                    stroke-width="2"
                    fill="none"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  >
                    <path d="M5 12h14"></path>
                    <path d="M12 5l7 7-7 7"></path>
                  </svg>
                </a>
                <div
                  class="text-center mt-2 leading-none flex justify-center absolute bottom-0 left-0 w-full py-4"
                >
                  <span
                    class="text-gray-600 mr-3 inline-flex items-center leading-none text-sm pr-3 py-1 border-r-2 border-gray-300"
                  >
                    <svg
                      class="w-4 h-4 mr-3"
                      fill="none"
                      stroke="currentColor"
                      viewBox="0 0 24 24"
                    >
                      <path
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        stroke-width="2"
                        d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z"
                      ></path>
                    </svg>
                    10-11-2020
                  </span>
                  <span
                    class="text-gray-600 inline-flex items-center leading-none text-sm"
                  >
                    3:00 PM
                  </span>
                </div>
              </div>
            </div>
            <div class="p-4 lg:w-1/3">
              <div
                class="h-full bg-gray-200 px-8 pt-16 pb-24 rounded-lg overflow-hidden text-center relative"
              >
                <h2
                  class="tracking-widest text-xs title-font font-medium text-gray-500 mb-1"
                >
                  ENTREGA
                </h2>
                <h1
                  class="title-font sm:text-2xl text-xl font-medium text-gray-900 mb-3"
                >
                  EN-5692
                </h1>
                <p class="leading-relaxed mb-3">
                  Av. Heroinas #1331 - Blanco Galindo Km.10. <br />
                  Entrega programada del mes de Octubre.
                </p>
                <a class="text-indigo-500 inline-flex items-center"
                  >Asignar Entrega
                  <svg
                    class="w-4 h-4 ml-2"
                    viewBox="0 0 24 24"
                    stroke="currentColor"
                    stroke-width="2"
                    fill="none"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  >
                    <path d="M5 12h14"></path>
                    <path d="M12 5l7 7-7 7"></path>
                  </svg>
                </a>
                <div
                  class="text-center mt-2 leading-none flex justify-center absolute bottom-0 left-0 w-full py-4"
                >
                  <span
                    class="text-gray-600 mr-3 inline-flex items-center leading-none text-sm pr-3 py-1 border-r-2 border-gray-300"
                  >
                    <svg
                      class="w-4 h-4 mr-3"
                      fill="none"
                      stroke="currentColor"
                      viewBox="0 0 24 24"
                    >
                      <path
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        stroke-width="2"
                        d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z"
                      ></path>
                    </svg>
                    10-11-2020
                  </span>
                  <span
                    class="text-gray-600 inline-flex items-center leading-none text-sm"
                  >
                    3:00 PM
                  </span>
                </div>
              </div>
            </div>
            <div class="p-4 lg:w-1/3">
              <div
                class="h-full bg-gray-200 px-8 pt-16 pb-24 rounded-lg overflow-hidden text-center relative"
              >
                <h2
                  class="tracking-widest text-xs title-font font-medium text-gray-500 mb-1"
                >
                  ENTREGA
                </h2>
                <h1
                  class="title-font sm:text-2xl text-xl font-medium text-gray-900 mb-3"
                >
                  EN-5692
                </h1>
                <p class="leading-relaxed mb-3">
                  Av. Heroinas #1331 - Blanco Galindo Km.10. <br />
                  Entrega programada del mes de Octubre.
                </p>
                <a class="text-indigo-500 inline-flex items-center"
                  >Asignar Entrega
                  <svg
                    class="w-4 h-4 ml-2"
                    viewBox="0 0 24 24"
                    stroke="currentColor"
                    stroke-width="2"
                    fill="none"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  >
                    <path d="M5 12h14"></path>
                    <path d="M12 5l7 7-7 7"></path>
                  </svg>
                </a>
                <div
                  class="text-center mt-2 leading-none flex justify-center absolute bottom-0 left-0 w-full py-4"
                >
                  <span
                    class="text-gray-600 mr-3 inline-flex items-center leading-none text-sm pr-3 py-1 border-r-2 border-gray-300"
                  >
                    <svg
                      class="w-4 h-4 mr-3"
                      fill="none"
                      stroke="currentColor"
                      viewBox="0 0 24 24"
                    >
                      <path
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        stroke-width="2"
                        d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z"
                      ></path>
                    </svg>
                    10-11-2020
                  </span>
                  <span
                    class="text-gray-600 inline-flex items-center leading-none text-sm"
                  >
                    3:00 PM
                  </span>
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
    </section>
  </section>
</template>

<script>
export default {};
</script>

<style lang="scss" scoped></style>
