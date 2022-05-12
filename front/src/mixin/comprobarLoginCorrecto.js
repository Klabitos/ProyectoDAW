import axios from "axios";
export default {
    data: () => ({
        nickname: ''
      }),
      methods: {
        async comprobarLoginCorrecto(username){ 
            this.nickname=username;
            const logged = await axios.get(`/meteOwn/v1/username/active`)
            .then(response => this.comprobarFormatoAdecuadoUsername(response.data))
            .catch(response => this.comprobarFormatoAdecuadoUsername(false));
        },
        comprobarFormatoAdecuadoUsername(activeUser) {
            if(activeUser!=this.nickname){
                this.$router.push({name:"Home"});
            }
        },
      },

  };