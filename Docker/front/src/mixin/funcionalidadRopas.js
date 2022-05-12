import axios from "axios";
export default {
    data: () => ({
        ropaActivaID:{ 
            cabeza:7,
            tronco:10,
            piernas:16,
            pies:20
        },
        datosRopa:{
            cabeza:[],
            tronco:[],
            piernas:[],
            pies:[]
        },
        datosRopaSinFiltrar:{},
        datosListos:false,
      }),
      methods: {
        async obtenerDatosGenericosRopa(){
            await axios.get(` /meteOwn/v1/ropas`)
            .then(response => this.datosRopaSinFiltrar = response.data)
            .catch(response => console.log("Error al recuperar datos"+ response.status)); 
        },
        async filtrarRopa(){
            for(let n=0; n< this.datosRopaSinFiltrar.length; n++){
                    if(this.datosRopaSinFiltrar[n].tipoRopa.tipoRopa==1){
                        this.datosRopa.cabeza.push(this.datosRopaSinFiltrar[n]);
                    }else if(this.datosRopaSinFiltrar[n].tipoRopa.tipoRopa==2){
                        this.datosRopa.tronco.push(this.datosRopaSinFiltrar[n]);
                    }else if(this.datosRopaSinFiltrar[n].tipoRopa.tipoRopa==3){
                        this.datosRopa.piernas.push(this.datosRopaSinFiltrar[n]);
                    }else{
                    this.datosRopa.pies.push(this.datosRopaSinFiltrar[n]);
                    }
            }
            this.datosListos=true;
        },
        obtenerURLCabeza(){
            for(let n=0; n<this.datosRopa.cabeza.length; n++){
                if(this.ropaActivaID.cabeza==this.datosRopa.cabeza[n].idRopa){
                    return this.datosRopa.cabeza[n].urlRelativa;
                }
            }
        },
        obtenerURLTronco(){
            for(let n=0; n<this.datosRopa.tronco.length; n++){
                if(this.ropaActivaID.tronco==this.datosRopa.tronco[n].idRopa){
                    return this.datosRopa.tronco[n].urlRelativa;
                }
            }
        },
        obtenerURLPiernas(){
            for(let n=0; n<this.datosRopa.piernas.length; n++){
                if(this.ropaActivaID.piernas==this.datosRopa.piernas[n].idRopa){
                    return this.datosRopa.piernas[n].urlRelativa;
                }
            }
        },
        obtenerURLPies(){
            for(let n=0; n<this.datosRopa.pies.length; n++){
                if(this.ropaActivaID.pies==this.datosRopa.pies[n].idRopa){
                    return this.datosRopa.pies[n].urlRelativa;
                }
            }
        },
        nextPies(){
            let idActivo = this.ropaActivaID.pies;
            let posicionDatos;
            let idSiguienteActivo;
            for(let n=0; n<this.datosRopa.pies.length; n++){
                if(idActivo==this.datosRopa.pies[n].idRopa){
                    posicionDatos=n;
                    break;
                }
            }
            if(posicionDatos==this.datosRopa.pies.length-1){ //último elemento
                idSiguienteActivo=this.datosRopa.pies[0].idRopa;
            }else{
                idSiguienteActivo=this.datosRopa.pies[posicionDatos+1].idRopa;
            }
            this.ropaActivaID.pies=idSiguienteActivo;
        },
        nextPiernas(){
            let idActivo = this.ropaActivaID.piernas;
            let posicionDatos;
            let idSiguienteActivo;
            for(let n=0; n<this.datosRopa.piernas.length; n++){
                if(idActivo==this.datosRopa.piernas[n].idRopa){
                    posicionDatos=n;
                    break;
                }
            }
            if(posicionDatos==this.datosRopa.piernas.length-1){ 
                idSiguienteActivo=this.datosRopa.piernas[0].idRopa;
            }else{
                idSiguienteActivo=this.datosRopa.piernas[posicionDatos+1].idRopa;
            }
            this.ropaActivaID.piernas=idSiguienteActivo;
        },
        nextTronco(){
            let idActivo = this.ropaActivaID.tronco;
            let posicionDatos;
            let idSiguienteActivo;
            for(let n=0; n<this.datosRopa.tronco.length; n++){
                if(idActivo==this.datosRopa.tronco[n].idRopa){
                    posicionDatos=n;
                    break;
                }
            }
            if(posicionDatos==this.datosRopa.tronco.length-1){ 
                idSiguienteActivo=this.datosRopa.tronco[0].idRopa;
            }else{
                idSiguienteActivo=this.datosRopa.tronco[posicionDatos+1].idRopa;
            }
            this.ropaActivaID.tronco=idSiguienteActivo;
        },
        nextCabeza(){
            let idActivo = this.ropaActivaID.cabeza;
            let posicionDatos;
            let idSiguienteActivo;
            for(let n=0; n<this.datosRopa.cabeza.length; n++){
                if(idActivo==this.datosRopa.cabeza[n].idRopa){
                    posicionDatos=n;
                    break;
                }
            }
            if(posicionDatos==this.datosRopa.cabeza.length-1){ 
                idSiguienteActivo=this.datosRopa.cabeza[0].idRopa;
            }else{
                idSiguienteActivo=this.datosRopa.cabeza[posicionDatos+1].idRopa;
            }
            this.ropaActivaID.cabeza=idSiguienteActivo;
        },
        prePies(){
            let idActivo = this.ropaActivaID.pies;
            let posicionDatos;
            let idSiguienteActivo;
            for(let n=0; n<this.datosRopa.pies.length; n++){
                if(idActivo==this.datosRopa.pies[n].idRopa){
                    posicionDatos=n;
                    break;
                }
            }
            if(posicionDatos==0){ //último elemento
                idSiguienteActivo=this.datosRopa.pies[this.datosRopa.pies.length-1].idRopa;
            }else{
                idSiguienteActivo=this.datosRopa.pies[posicionDatos-1].idRopa;
            }
            this.ropaActivaID.pies=idSiguienteActivo;
        },
        prePiernas(){
            let idActivo = this.ropaActivaID.piernas;
            let posicionDatos;
            let idSiguienteActivo;
            for(let n=0; n<this.datosRopa.piernas.length; n++){
                if(idActivo==this.datosRopa.piernas[n].idRopa){
                    posicionDatos=n;
                    break;
                }
            }
            if(posicionDatos==0){
                idSiguienteActivo=this.datosRopa.piernas[this.datosRopa.piernas.length-1].idRopa;
            }else{
                idSiguienteActivo=this.datosRopa.piernas[posicionDatos-1].idRopa;
            }
            this.ropaActivaID.piernas=idSiguienteActivo;
        },
        preTronco(){
            let idActivo = this.ropaActivaID.tronco;
            let posicionDatos;
            let idSiguienteActivo;
            for(let n=0; n<this.datosRopa.tronco.length; n++){
                if(idActivo==this.datosRopa.tronco[n].idRopa){
                    posicionDatos=n;
                    break;
                }
            }
            if(posicionDatos==0){ 
                idSiguienteActivo=this.datosRopa.tronco[this.datosRopa.tronco.length-1].idRopa;
            }else{
                idSiguienteActivo=this.datosRopa.tronco[posicionDatos-1].idRopa;
            }
            this.ropaActivaID.tronco=idSiguienteActivo;
        },
        preCabeza(){
            let idActivo = this.ropaActivaID.cabeza;
            let posicionDatos;
            let idSiguienteActivo;
            for(let n=0; n<this.datosRopa.cabeza.length; n++){
                if(idActivo==this.datosRopa.cabeza[n].idRopa){
                    posicionDatos=n;
                    break;
                }
            }
            if(posicionDatos==0){ 
                idSiguienteActivo=this.datosRopa.cabeza[this.datosRopa.cabeza.length-1].idRopa;
            }else{
                idSiguienteActivo=this.datosRopa.cabeza[posicionDatos-1].idRopa;
            }
            this.ropaActivaID.cabeza=idSiguienteActivo;
        },
        

      },

  };