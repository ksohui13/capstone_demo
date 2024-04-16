<template>
  <div id="app">
    <div class="login-container">
      <div class="logo">
      <img :src="require('@/assets/esglogo.png')" alt="esglogo" />
    </div>
    <form @submit.prevent="login">
        <div class="form-group">
        <input type="email" v-model="email" placeholder="이메일을 입력해주세요." />
          </div>
      <div class="form-group">
        <input type="password" v-model="password" placeholder="비밀번호를 입력해주세요" /><br />
      </div>
      <div class="form-group">
        <button @click="login">로그인</button>
        </div>
      </form>
      <div class="signup-link">
      <p>계정이 없으신가요? <router-link to="/signup">회원가입</router-link></p>
    </div>
    </div>
  </div>
</template>

<script>
import firebase from 'firebase';

export default {
  name: 'Login',
  data() {
    return {
      email: '',
      password: '',
    };
  },
  methods: {
    login() {
      firebase
        .auth()
        .signInWithEmailAndPassword(this.email, this.password)
        .then((user) => {
          alert('로그인 완료!');
        })
        .catch((err) => {
          alert('에러 : ' + err.message);
        });
    },
  },
};
</script>

<style>
.login-container {
  max-width: 300px;
  margin: auto;
  text-align: center;
  padding: 20px;
  background-color: #fff;
}

.logo img {
  width: 100px;
  margin-bottom: 20px;
}

.form-group {
  margin-bottom: 15px;
}

.form-group input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
}

.form-group button {
  width: 100%;
  padding: 10px;
  background-color: #0044cc;
  border: none;
  color: white;
}

.signup-link {
  margin-top: 20px;
}

.signup-link a {
  color: #0044cc;
}
</style>