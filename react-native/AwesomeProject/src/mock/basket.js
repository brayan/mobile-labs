import imageFarmLogo from '../../assets/logo.png'

import tomato from '../../assets/frutas/Tomate.png';
import broccoli from '../../assets/frutas/Brocolis.png';
import potato from '../../assets/frutas/Batata.png';
import cucumber from '../../assets/frutas/Pepino.png';
import pumpkin from '../../assets/frutas/Abobora.png';

const basket = {
    header: {
        title: "Basket Details",
    },
    details: {
        name: "Basket of vegetables",
        farm: {
            name: "Jenny Jack Farm",
            logo: imageFarmLogo,
        },
        description: "Uma cesta com produtos selecionados cuidadosamente da fazenda direto para sua cozinha",
        price: "R$ 40,00",
        button: "Comprar",
    },
    items: {
        title: "Itens da cesta",
        list: [
            {
                name: "Tomate",
                image: tomato,
            },
            {
                name: "Brócolis",
                image: broccoli,
            },
            {
                name: "Batata",
                image: potato,
            },
            {
                name: "Pepino",
                image: cucumber,
            },
            {
                name: "Abóbora",
                image: pumpkin,
            },
        ]
    }
}

export default basket;