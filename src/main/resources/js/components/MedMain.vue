<template>
  <div class="main">
      <Schedule></Schedule>
  </div>
</template>

<script>
import Schedule from "./Schedule";
export default {
  name: 'MedMain',
  components: {Schedule},
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
a {
  color: #42b983;
}

.main {
  /*background-color: honeydew;*/
  border: 1px dotted #111;
  min-height: 400px;

}
</style>
