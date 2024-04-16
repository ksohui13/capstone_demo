<template>  
  <div>
    <button @click="fetchData">Spring Boot데이터 가져오기</button>
    <ul>
      <li v-for="(item, index) in items" :key="index">{{ item }}</li>
    </ul>
    <button @click="get">데이터 가져오기</button>
    <p>{{ data }}</p>
  </div>
  </template>
  
  <script>
  import axios from 'axios'

  export default {
    data() {
      return {
        items: [],
        data: [],
        id: 1,
      };
    },
    methods: {
    fetchData() {
      axios.get('http://localhost:8080/api/items')
        .then(response => {
          this.items = response.data;
        })
        .catch(error => {
          console.error('데이터를 가져오는 중 오류 발생:', error);
        });
    },
    get() {
      axios
        .get(`https://jsonplaceholder.typicode.com/todos/${this.id}`)
        .then((result) => {
          console.log(result.data);
          this.data.push(result.data);
          this.id++;
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => {
          console.log("finally");
        });
    },
  }
  };
  </script>
  
  <style>

  </style>
  