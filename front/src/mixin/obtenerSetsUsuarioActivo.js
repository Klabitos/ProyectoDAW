import axios from "axios";
export default {
    data: () => ({
        todosSetUsuario:[],
        idUsuario: ''
      }),
      methods: {
        async obtenerIdUsuarioActivoConUsername(username){
            await axios.get(`/meteOwn/v1/username/getId/${username}`)
              .then(response => this.idUsuario=response.data)
              .catch(response => console.log("Error al recuperar datos "+ response.status));
            await this.obtenerSetsUsuario(); 
       },
        async obtenerSetsUsuario(){
            await axios.get(`/meteOwn/v1/conjuntos?idUsuario=${this.idUsuario}`)
              .then(response => this.todosSetUsuario=response.data)
              .catch(response => console.log("Error al recuperar datos "+ response.status));
        },
      },

  };