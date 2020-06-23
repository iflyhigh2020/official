import request from '../utils/request';

export const fetchData = query => {
    return request({
        url: './table.json',
        method: 'get',
        params: query
    });
};

import axios from 'axios'

export default axios.create({
    baseURL: '',
    timeout: 10000
})