<template>
  <body class="loginContainer">
  <div id="app">
    <div class="container">
      <div class="inner">
        <div class="signIn" v-if="signIn">
          <div class="top">
            <div class="title">Sign in</div>
            <div class="subtitle">
              Don't have an account?
              <span class="subtitle-action" @click="signIn = !signIn">
                Create Account
              </span>
            </div>
          </div>
            <div class="form">
              <input
                  required
                  aria-required="true"
                  aria-invalid="false"
                  aria-label="E-mail"
                  type="email"
                  pattern="^[\w\.-]+@[\w\.-]+\.\w+$"
                  class="w100"
                  :class="{ invalid: email.error }"
                  ref="email"
                  placeholder="Email"
                  autofocus
                  @blur="validateEmail"
                  @keydown="validateEmail"
                  v-model="email.value"
              />

              <input
                  required
                  aria-required="true"
                  type="password"
                  class="w100"
                  :class="{ invalid: password.error }"
                  placeholder="Password"
                  v-model="password.value"
                  @blur="validatePassword"
                  @keydown="validatePassword"
              />
            </div>

            <input
                type="submit"
                value="Submit"
                class="action"
                :class="{ 'action-disabled': !loginValid }"
                @click="loginUser()"
            />
        </div>

        <div class="register" v-else>
          <div class="top">
            <img
                class="logo"
                src="https://res.cloudinary.com/dc3c8nrut/image/upload/v1685298768/logo-placeholder_l3yodl.png"
            />
            <div class="title">Create an Account</div>
            <div class="subtitle">
              Already have an account?
              <span class="subtitle-action" @click="signIn = !signIn">
                Sign In
              </span>
            </div>
          </div>

          <div class="form">
            <input
                type="text"
                placeholder="First name"
                autofocus
                v-model="firstName"
                class="w100"
            />

            <input
                type="text"
                placeholder="Last name"
                v-model="lastName"
                class="w100"
            />

            <input
                type="text"
                class="w100"
                placeholder="Email"
                v-model="email.value"
            />
            <input
                type="password"
                class="w100"
                placeholder="Password"
                v-model="password.value"
            />
            <input
                type="password"
                class="w100"
                placeholder="Repeat password"
                v-model="repeatpassword.value"
            />
          </div>

          <input
              type="submit"
              value="Create account"
              class="action"
              :class="{ 'action-disabled': !registerValid }"
              @click="registerUser()"
          />
        </div>
      </div>
    </div>
  </div>
  </body>
</template>

<script>
import "@/Layouts/authenticationStyle.css"
import authService from "../../Services/authService.js";
export default {
  data() {
    return {
      emailRegex: /^[\w\.-]+@[\w\.-]+\.\w+$/,
      passwordRegex: /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$/,



      password: {
        value: "",
        error: false
      },
      repeatpassword:{
        value: "",
        error: false
      },

      email: {
        value: "",
        error: false
      },
      firstName: "",
      lastName: "",

      signIn: true
    };
  },

  methods: {
    validateEmail(event) {
      if (this.email.value == "") this.email.error = true;
      else this.email.error = false;
    },

    validatePassword(event) {
      if (this.password.value == "") this.password.error = true;
      else this.password.error = false;
    },
  validaterepeatPassword(event) {
    if (this.repeatpassword.value != this.password.value) this.repeatpassword.error = true;
    else this.repeatpassword.error = false;
  },
    registerUser() {
      // Construct data object to send
      const data = {
        email: this.email.value,
        hashedPassword: this.password.value,
        firstName: this.firstName,
        lastName: this.lastName
      };
      authService.sendRegister(data)
    },

    loginUser() {
      // Construct data object to send
      const data = {
        email: this.email.value,
        hashedPassword: this.password.value,
      };
      authService.sendLogin(data)
    }
},

  mounted() {
    // this.$refs.email.focus();
  },

  computed: {
    validFirstName() {
      return this.firstName.length > 0;
    },

    validLastName() {
      return this.lastName.length > 0;
    },

    emailValid() {
      return this.emailRegex.test(this.email.value);
    },

    passwordValid() {
      return this.password.value.length > 0;
    },

    repeatpasswordValid() {
      return this.repeatpassword.value.length > 0;
    },

    loginValid() {
      return this.emailValid && this.passwordValid;
    },

    registerValid() {
      return (
          this.emailValid &&
          this.passwordValid &&
          this.repeatpasswordValid &&
          this.validFirstName &&
          this.validLastName
      );

    }
  }
};
</script>

<!-- Use preprocessors via the lang attribute! e.g. <style lang="scss"> -->
<!--
<style lang="scss">
@mixin box {
  box-shadow: 1px 1px 2px 1px #ccc;
}

@mixin field {
  border: 1px solid #aaa;
  height: 40px;
  padding: 10px;
  margin-top: 20px;
  border-radius: 5px;
  box-sizing: border-box;
}

input[type="text"] {
  @include field;
}

input[type="email"] {
  @include field;
}

input[type="password"] {
  @include field;
}

.invalid {
  border: 2px solid red !important;
  &::placeholder {
    color: red;
  }
}

.errorMessage {
  color: red;
  margin: 10px;
  top: 5px;
}

.w100 {
  width: 100%;
}

#app {
}

.logo {
  width: 300px;
  margin-bottom: 10px;
}

.action {
  height: 40px;
  text-transform: uppercase;
  border-radius: 25px;
  width: 100%;
  border: none;
  cursor: pointer;
  background: green;
  margin-top: 20px;
  color: #fff;
  font-size: 1.2rem;
  @include box;
}

.action-disabled {
  color: #eee;
  background: #aaa;
  cursor: auto;
}

.top {
  display: flex;
  align-items: center;
  flex-direction: column;
  margin-bottom: 10px;
}

.title {
  width: 100%;
  font-size: 1.8rem;
  margin-bottom: 10px;
  text-align: center;
}

.subtitle {
  .subtitle-action {
    color: green;
    font-weight: bold;
    cursor: pointer;
  }
}

html {
  background-repeat: no-repeat;
  background-color: gray;
  background-size: cover;
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
  font-family: sans-serif;
}

.loginBox {
  background: #fff;
  border-radius: 15px;
  max-width: 400px;
  padding: 25px 55px;
  animation: slideInTop 1s;
}

@keyframes slideInTop {
  from {
    opacity: 0;
    transform: translateY(-30%);
  }

  to {
    opacity: 100;
    transform: translateY(0%);
  }
}

@media screen and (min-width: 440px) {
  .loginBox {
    @include box;
  }
}

@media screen and (max-width: 440px) {
  html {
    background: #fff;
    align-items: start;
    justify-content: start;
  }

  .loginBox {
    padding: 25px 25px;
    max-width: 100vw;
  }
}
</style>-->
