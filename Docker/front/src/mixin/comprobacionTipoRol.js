import axios from "axios";
export default {
    data: () => ({
        myRole: ''
      }),
      methods: {
        obtenerRol(nickname){
          axios.get(`/meteOwn/v1/security/authority/isAdmin/${nickname}`)
          .then(response => this.myRole=response.data)
          .catch(response => this.myRole=response.data);
        }
      },

  };