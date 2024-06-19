import axios from 'axios'

const BASE_API_URL = 'http://localhost:8081/orders'


async function getOrders(){
    var data = null
    try{
        var response = await axios.get(`${BASE_API_URL}`)
        if(response.status != 200)
            return null
        data = response.data
    }catch{
        console.log('[Error]: Failed to fetch orders')
    }
    return data
}
async function getByID(id) {
    var data = null
    try {
        if (isNaN(id))

            return null


        var response = await axios.get(`${BASE_API_URL}/${id}`)
        if (response.status != 200)
            return null

        data = response.data
    } catch {
        console.log('[Error]: Failed to fetch products')
    }

    return data
}

/*
async function setAccepted(order){}

*/

export default {
    getOrders,
    getByID

}