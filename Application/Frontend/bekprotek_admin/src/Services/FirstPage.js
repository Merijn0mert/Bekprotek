import axios from 'axios'

const BASE_API_URL = 'http://localhost:8081'

async function getByID(id) {
    var data = null
    id = "foo"
    try {
        if (!isNaN(id))
            return null
        
        
        var response = await axios.get(`${BASE_API_URL}/${id}`)
        console.log(id)
        if (response.status != 200)
            return null

        data = response.data
        console.log(data + " " + "yeet")
    } catch {
        console.log('[Error]: Failed to fetch products')
    }

    return data
}


export default {
    getByID 
}