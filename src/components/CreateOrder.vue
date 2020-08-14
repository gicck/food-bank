<template>
  <FormulateForm :schema="schema"/>
</template>

<script>
const schema = [
  {
    "component": "h3",
    "children": "Nueva Orden"
  },
  {
    "label": "ID Orden",
    "name": "order_id",
    "help": "El ID de la Orden (ex. OE-14414)",
    "placeholder": "OE-",
    "validation": "^required|matches:/^ST-[\\d]{5}$/",
    "validation-name": "Student ID"
  }, 
  {
    "type": "select",
    "label": "Entidad",
    "name": "entity",
    "placeholder": "Selecciona una entidad de apoyo",
    "options": {
      "sanRafael": "Hogar de Ninos San Rafael - 50 beneficiarios",
      "aldeasSos": "Aldeas S.O.S. - 150 beneficiarios",
      "patitasDescalzas": "Albergue Comunitario \"Patitas Descalzas\" - 70 beneficiarios"
    },
    "validation": "required"
  },
  {
    "label": "Nombre Encargado",
    "name": "name",
    "help": "Nombre del encargado de la entidad beneficiada",
    "validation": "required"
  },
  {
    "type": "text",
    "label": "Telefono Encargado",
    "name": "phone",
    "inputmode": "numeric",
    "pattern": "[0-9]*",
    "validation": "matches:/^[0-9-]+$/",
    "validation-messages": {
      "matches": "El telefono solo debe contener digitos"
    }
  },
  {
    "label": "Delegado del Banco",
    "name": "name",
    "help": "Responsable del banco de alimentos",
    "validation": "required"
  },  
  {
    "type": "group",
    "name": "items",
    "validation": "min:1,length",
    "repeatable": true,
    "add-label": "+ Añadir item",
    "value": [{}],
    "children": [
      {
        "type": "select",
        "name": "platform",
        "label": "Tipo Item",
        "placeholder": "Selecciona uno",
        "options": {
          "twitter": "cereales y derivados",
          "facebook": "verduras y legumbres frescas",
          "instagram": "frutas frescas",
          "linkedin": "aceites y grasas",
          "lactose": "productos lácteos",          
          "meat": "carnes, pescados y legumbres secas"
        }
      },
      {
        "type": "text",
        "name": "url",
        "label": "Nombre",
        "validation": "required"
      },
      {
        "type": "select",
        "name": "country_code",
        "label": "Medida",
        "outer-class": ["flex-item-small"],
        "value": "1",
        "options": {
          "1": "Kg",
          "49": "Unidad"          
        }
      },
      {
        "label": "Cantidad",
        "name": "name",
        "validation": "required"
      }
    ]
  },
  {
    "type": "submit",
    "label": "Crear Orden"
  }
];

export default {
  name: "CreateOrder",
  props: {
    msg: String
  },
  data () {
    return {
      value: 'My initial value',
      schema
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
