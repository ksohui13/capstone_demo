<template>
  <div class="sign-up">
    <p>회원가입</p>
    <input type="text" v-model="email" placeholder="이메일을 입력하세요."><br>
    <input type="password" v-model="password" placeholder="비밀번호를 입력하세요"><br>
    <input type="password" placeholder="비밀번호를 한 번 더 입력하세요"><br>
    <p>회사 정보</p>
    <input type="text" v-model="companyName" placeholder="회사명을 입력하세요."><br>
    <input type="text" v-model="managerName" placeholder="담당자 성함">
    <input type="text" v-model="managerContact" placeholder="담당자연락처"><br>
    <input type="text" v-model="department" placeholder="부서명을 입력해주세요."><br>
    <input type="text" v-model="businessField" placeholder="사업분야"><br>
    <p>수출기업 여부</p> 
    <button @click="setExportStatus(true)">수출기업</button>
    <button @click="setExportStatus(false)">비수출기업</button><br>
    <button v-on:click="signUp">회원가입</button>
    <span>또는 <router-link to="/login">로그인</router-link>으로 돌아가기</span>
  </div>
</template>

<script>
import firebase from 'firebase'

export default {
  name: 'signUp',
  data() {
    return {
      email: '',
      password: '',
      companyName: '',
      managerName: '',
      managerContact: '',
      department: '',
      businessField: '',
      isExporter: false
    }
  },
  methods: {
    setExportStatus(status) {
      this.isExporter = status;
    },
    signUp() {
      firebase.auth().createUserWithEmailAndPassword(this.email, this.password)
        .then((userCredential) => {
          // 회원가입 성공 후 추가 정보를 데이터베이스에 저장
          const userId = userCredential.user.uid;
          firebase.database().ref('users/' + userId).set({
            companyName: this.companyName,
            managerName: this.managerName,
            managerContact: this.managerContact,
            department: this.department,
            businessField: this.businessField,
            isExporter: this.isExporter
          });
          alert('회원가입 완료!');
        })
        .catch((error) => {
          alert('에러: ' + error.message);
        });
    }
  }
}
</script>

  <style scoped>
.sign-up {
  width: 100%;
  max-width: 500px; /* Adjust the form width as necessary */
  background: #fff;
  padding: 20px;
  box-sizing: border-box;
  margin: 40px auto;
  border-radius: 8px; /* Optional: if you want rounded corners */
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Optional: if you want a shadow */
}

.sign-up p {
  font-size: 24px; /* Larger font for the title and section headers */
  color: #333; /* Darker text color for better readability */
  margin-bottom: 20px; /* Space before the inputs */
}

.sign-up input[type="text"],
.sign-up input[type="password"],
.sign-up input[type="email"],
.sign-up button {
  width: calc(100% - 40px); /* Full width minus padding */
  padding: 15px;
  margin-bottom: 10px; /* Space between each input/button */
  border: 1px solid #ccc; /* Border to match the uploaded image */
  border-radius: 4px; /* Slightly rounded borders for the inputs/buttons */
  box-sizing: border-box;
}

.sign-up button {
  background-color: #446CB3; /* Assuming a blue color for the button */
  color: white;
  border: none;
  font-size: 18px;
  font-weight: bold;
}

.sign-up span {
  font-size: 16px;
  color: #888;
  display: block;
  text-align: center;
  margin-top: 20px;
}

.sign-up router-link {
  color: #446CB3; /* Link color matching the buttons */
  text-decoration: none;
}

.sign-up router-link:hover {
  text-decoration: underline;
}

/* This is to style the button when it's not in focus (like in the image) */
.sign-up button:not(:focus) {
  opacity: 0.7;
}

/* Adjusts the layout for the manager name and contact fields */
.sign-up .manager-info {
  display: flex;
  justify-content: space-between;
}

.sign-up .manager-info input {
  width: 48%; /* Adjust the width of these inputs to fit side by side */
}

/* You may need to add more specific styles or adjust these according to the rest of your page's styling */
</style>