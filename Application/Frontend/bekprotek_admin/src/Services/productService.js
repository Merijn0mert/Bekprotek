import axios from 'axios'

const BASE_API_URL = 'http://localhost:8081/products'


async function getProducts(){
    var data = null
    try{
        var response = await axios.get(`${BASE_API_URL}`)
        if(response.status != 200)
            return null
        data = response.data
    }catch{
        console.log('[Error]: Failed to fetch products')
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
async function addProduct(product) {
    try {
        const response = await axios.post('http://localhost:8081/products/addproduct', product);
        console.log('Product added:', response.data);
    } catch (error) {
        console.error('Error adding product:', error);
    }
}


export default {
    getProducts,
    getByID,
    addProduct

}