import axios from 'axios';
import { LoginRequest, RegisterRequest, Service, BoostOrder, ServiceRequest, ApiResponse } from '../types';

const API_BASE_URL = '/api/v1';

// Create axios instance with default config
const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

// Request interceptor to add JWT token
api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('token');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

// Response interceptor to handle errors
api.interceptors.response.use(
  (response) => response,
  (error) => {
    if (error.response?.status === 401) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      window.location.href = '/login';
    }
    return Promise.reject(error);
  }
);

// Auth API
export const authAPI = {
  login: async (credentials: LoginRequest): Promise<string> => {
    const response = await api.post('/auth/login', credentials);
    return response.data;
  },
  
  register: async (userData: RegisterRequest): Promise<string> => {
    const response = await api.post('/auth/register', userData);
    return response.data;
  },
};

// Services API
export const servicesAPI = {
  getAllServices: async (page = 0, size = 20): Promise<ApiResponse<Service>> => {
    const response = await api.get(`/services/all?page=${page}&size=${size}`);
    return response.data;
  },
  
  getServiceById: async (id: number): Promise<Service> => {
    const response = await api.get(`/services/${id}`);
    return response.data;
  },
  
  createService: async (service: ServiceRequest): Promise<void> => {
    await api.post('/services/create', service);
  },
  
  updateService: async (id: number, service: ServiceRequest): Promise<Service> => {
    const response = await api.put(`/services/update/${id}`, service);
    return response.data;
  },
  
  deleteService: async (id: number): Promise<void> => {
    await api.delete(`/services/delete/${id}`);
  },
};

// User Orders API
export const userOrdersAPI = {
  requestBoost: async (serviceId: number): Promise<void> => {
    await api.post(`/user/orders/boost-orders/${serviceId}`);
  },
  
  deleteBoost: async (orderId: number): Promise<void> => {
    await api.delete(`/user/orders/delete/${orderId}`);
  },
  
  getMyOrders: async (page = 0, size = 20): Promise<ApiResponse<BoostOrder>> => {
    const response = await api.get(`/user/orders/get-my-orders?page=${page}&size=${size}`);
    return response.data;
  },
};

// Booster Orders API
export const boosterOrdersAPI = {
  getMyBoosts: async (page = 0, size = 20): Promise<ApiResponse<BoostOrder>> => {
    const response = await api.get(`/boost-orders/get-my-orders?page=${page}&size=${size}`);
    return response.data;
  },
  
  acceptBoost: async (boostId: number): Promise<void> => {
    await api.patch(`/boost-orders/accept/${boostId}`);
  },
  
  cancelBoost: async (boostId: number): Promise<void> => {
    await api.patch(`/boost-orders/decline/${boostId}`);
  },
};

export default api;
