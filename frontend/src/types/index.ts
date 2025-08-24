export interface User {
  id: number;
  username: string;
  email: string;
  role: 'ROLE_USER' | 'ROLE_BOOSTER' | 'ROLE_ADMIN' | 'ROLE_SUPER_ADMIN';
}

export interface Service {
  id: number;
  name: string;
  description?: string;
  coverImageURL?: string;
  isActive: boolean;
  createdAt: string;
  updatedAt: string;
}

export interface BoostOrder {
  id: number;
  userId: number;
  boosterId?: number;
  createdAt: string;
  boostStatus: 'ACTIVE' | 'TAKEN' | 'COMPLETED' | 'CANCELLED';
  acceptedAt?: string;
  serviceId: number;
  deleted: boolean;
  service?: Service;
}

export interface LoginRequest {
  username: string;
  password: string;
}

export interface RegisterRequest {
  username: string;
  password: string;
  email: string;
}

export interface ServiceRequest {
  name: string;
  description?: string;
  coverImageURL?: string;
}

export interface ApiResponse<T> {
  content: T[];
  totalElements: number;
  totalPages: number;
  size: number;
  number: number;
}
