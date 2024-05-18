<template>
  <div>
    <button @click="fetchData">Spring Boot 데이터 가져오기</button>
    <ul>
      <li v-for="(item, index) in items" :key="index">{{ item }}</li>
    </ul>
    <button @click="get">데이터 가져오기</button>
    <p>{{ data }}</p>
    <button @click="fetchFirebaseToken">Firebase ID Token 확인</button>
    <p>{{ userToken }}</p>
  </div>
</template>

<script>
import axios from 'axios'
import firebase from 'firebase';

export default {
  data() {
    return {
      items: [],
      data: [],
      id: 1,
      userToken: null,
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
    fetchFirebaseToken() {
      // Replace with your Firebase authentication logic
      // For example, sign in with email and password
      // Then get the ID token
      // This is a placeholder example
      // You should replace it with your actual Firebase authentication code
      // and handle errors appropriately
      firebase.auth().signInWithEmailAndPassword('test@test.com', 'testtest')
          .then(({user}) => {
            return user.getIdToken();
          })
          .then(token => {
            this.userToken = token;
            console.log('Firebase ID Token:', token);
          })
          .catch(error => {
            console.error('Firebase 로그인 실패:', error);
          });
    }
  }
};
</script>

<style>

</style>
  