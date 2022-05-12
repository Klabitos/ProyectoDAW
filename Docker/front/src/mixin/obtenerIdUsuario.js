import axios from "axios";
export default {
    data: () => ({
        idUsuario: ''
      }),
      methods: {
        async obtenerIdUsuarioActivo(username){
            await axios.get(`/meteOwn/v1/username/getId/${username}`)
              .then(response => this.idUsuario=response.data)
              .catch(response => console.log("Error al recuperar datos "+ response.status));
            
       },
      },

  };