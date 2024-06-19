import axios from 'axios'

const BASE_API_URL = 'http://localhost:8081/auth'


async function sendLogin(data) {
    try {
        const response = await axios.post(`${BASE_API_URL}/login`, data, {
            headers: {
                'Content-Type': 'application/json',
            }
        });
        console.log('Response status:', response.status);
        console.log('Response data:', response.data);

        const result = response.data; // assuming the backend returns JSON
        window.location.href = '${BASE_API_URL}/';
        return result; // returning the parsed JSON
    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
        throw error; // rethrowing the error after logging it
    }
}

async function sendRegister(data) {
    try {
        const response = await axios.post(`${BASE_API_URL}/register`, data,{
            method: 'POST', // or 'PUT' depending on your requirement
            headers: {
                'Content-Type': 'application/json', // setting the content type to JSON
            },
            body: data, // converting data to JSON string
        });

        const result = await response.json(); // assuming the backend returns JSON
        return result; // returning the parsed JSON
    } catch (error) {
        console.error('There was a problem with the fetch operation:', error);
        throw error; // rethrowing the error after logging it
    }
}

export default {
    sendLogin,
    sendRegister
}