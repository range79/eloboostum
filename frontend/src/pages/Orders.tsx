import React, { useState, useEffect } from 'react';
import { 
  ClockIcon, 
  CheckCircleIcon, 
  XCircleIcon,
  ExclamationTriangleIcon,
  TrashIcon,
  EyeIcon
} from '@heroicons/react/24/outline';
import { userOrdersAPI } from '../services/api';
import { BoostOrder } from '../types';

const Orders: React.FC = () => {
  const [orders, setOrders] = useState<BoostOrder[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [deletingOrder, setDeletingOrder] = useState<number | null>(null);

  useEffect(() => {
    fetchOrders();
  }, []);

  const fetchOrders = async () => {
    try {
      setLoading(true);
      const response = await userOrdersAPI.getMyOrders();
      setOrders(response.content);
    } catch (err: any) {
      setError('Failed to load orders. Please try again.');
    } finally {
      setLoading(false);
    }
  };

  const handleDeleteOrder = async (orderId: number) => {
    if (!window.confirm('Are you sure you want to delete this order?')) {
      return;
    }

    try {
      setDeletingOrder(orderId);
      await userOrdersAPI.deleteBoost(orderId);
      setOrders(orders.filter(order => order.id !== orderId));
    } catch (err: any) {
      alert(err.response?.data?.message || 'Failed to delete order. Please try again.');
    } finally {
      setDeletingOrder(null);
    }
  };

  const getStatusIcon = (status: string) => {
    switch (status) {
      case 'ACTIVE':
        return <ClockIcon className="h-5 w-5 text-yellow-500" />;
      case 'TAKEN':
        return <ExclamationTriangleIcon className="h-5 w-5 text-blue-500" />;
      case 'COMPLETED':
        return <CheckCircleIcon className="h-5 w-5 text-green-500" />;
      case 'CANCELLED':
        return <XCircleIcon className="h-5 w-5 text-red-500" />;
      default:
        return <ClockIcon className="h-5 w-5 text-gray-500" />;
    }
  };

  const getStatusColor = (status: string) => {
    switch (status) {
      case 'ACTIVE':
        return 'bg-yellow-100 text-yellow-800';
      case 'TAKEN':
        return 'bg-blue-100 text-blue-800';
      case 'COMPLETED':
        return 'bg-green-100 text-green-800';
      case 'CANCELLED':
        return 'bg-red-100 text-red-800';
      default:
        return 'bg-gray-100 text-gray-800';
    }
  };

  const getStatusText = (status: string) => {
    switch (status) {
      case 'ACTIVE':
        return 'Waiting for Booster';
      case 'TAKEN':
        return 'In Progress';
      case 'COMPLETED':
        return 'Completed';
      case 'CANCELLED':
        return 'Cancelled';
      default:
        return status;
    }
  };

  // Mock orders data for demonstration
  const mockOrders: BoostOrder[] = [
    {
      id: 1,
      userId: 1,
      serviceId: 1,
      boostStatus: 'ACTIVE',
      createdAt: new Date(Date.now() - 86400000).toISOString(), // 1 day ago
      deleted: false,
      service: {
        id: 1,
        name: 'Bronze to Silver',
        description: 'Professional boost from Bronze to Silver rank.',
        isActive: true,
        createdAt: new Date().toISOString(),
        updatedAt: new Date().toISOString(),
      },
    },
    {
      id: 2,
      userId: 1,
      serviceId: 2,
      boosterId: 2,
      boostStatus: 'TAKEN',
      createdAt: new Date(Date.now() - 172800000).toISOString(), // 2 days ago
      acceptedAt: new Date(Date.now() - 86400000).toISOString(),
      deleted: false,
      service: {
        id: 2,
        name: 'Silver to Gold',
        description: 'Climb from Silver to Gold with our professional boosters.',
        isActive: true,
        createdAt: new Date().toISOString(),
        updatedAt: new Date().toISOString(),
      },
    },
    {
      id: 3,
      userId: 1,
      serviceId: 3,
      boosterId: 3,
      boostStatus: 'COMPLETED',
      createdAt: new Date(Date.now() - 604800000).toISOString(), // 1 week ago
      acceptedAt: new Date(Date.now() - 518400000).toISOString(),
      deleted: false,
      service: {
        id: 3,
        name: 'Gold to Platinum',
        description: 'Advanced boosting service from Gold to Platinum.',
        isActive: true,
        createdAt: new Date().toISOString(),
        updatedAt: new Date().toISOString(),
      },
    },
  ];

  const displayOrders = orders.length > 0 ? orders : mockOrders;

  if (loading) {
    return (
      <div className="min-h-screen flex items-center justify-center">
        <div className="animate-spin rounded-full h-32 w-32 border-b-2 border-primary-600"></div>
      </div>
    );
  }

  return (
    <div className="bg-gray-50 min-h-screen">
      {/* Header */}
      <div className="bg-white shadow">
        <div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8 py-8">
          <div className="flex items-center justify-between">
            <div>
              <h1 className="text-3xl font-bold text-gray-900">My Orders</h1>
              <p className="mt-2 text-gray-600">
                Track your boost orders and their current status
              </p>
            </div>
            <div className="text-right">
              <p className="text-sm text-gray-500">Total Orders</p>
              <p className="text-2xl font-bold text-primary-600">{displayOrders.length}</p>
            </div>
          </div>
        </div>
      </div>

      {/* Orders List */}
      <div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8 py-8">
        {error && (
          <div className="mb-8 rounded-md bg-red-50 p-4">
            <div className="flex">
              <div className="ml-3">
                <h3 className="text-sm font-medium text-red-800">{error}</h3>
              </div>
            </div>
          </div>
        )}

        {displayOrders.length === 0 ? (
          <div className="text-center py-12">
            <div className="mx-auto h-12 w-12 text-gray-400">
              <ClockIcon className="h-12 w-12" />
            </div>
            <h3 className="mt-2 text-sm font-medium text-gray-900">No orders</h3>
            <p className="mt-1 text-sm text-gray-500">
              Get started by requesting a boost service.
            </p>
            <div className="mt-6">
              <a
                href="/services"
                className="btn-primary"
              >
                View Services
              </a>
            </div>
          </div>
        ) : (
          <div className="space-y-6">
            {displayOrders.map((order) => (
              <div key={order.id} className="card">
                <div className="flex items-center justify-between">
                  <div className="flex items-center space-x-4">
                    <div className="flex-shrink-0">
                      {getStatusIcon(order.boostStatus)}
                    </div>
                    <div className="flex-1 min-w-0">
                      <div className="flex items-center space-x-3">
                        <h3 className="text-lg font-medium text-gray-900">
                          {order.service?.name || `Service #${order.serviceId}`}
                        </h3>
                        <span className={`inline-flex items-center px-2.5 py-0.5 rounded-full text-xs font-medium ${getStatusColor(order.boostStatus)}`}>
                          {getStatusText(order.boostStatus)}
                        </span>
                      </div>
                      <p className="text-sm text-gray-500 mt-1">
                        {order.service?.description}
                      </p>
                      <div className="flex items-center space-x-4 mt-2 text-sm text-gray-500">
                        <span>Order ID: #{order.id}</span>
                        <span>Created: {new Date(order.createdAt).toLocaleDateString()}</span>
                        {order.acceptedAt && (
                          <span>Started: {new Date(order.acceptedAt).toLocaleDateString()}</span>
                        )}
                      </div>
                    </div>
                  </div>
                  
                  <div className="flex items-center space-x-2">
                    <button
                      className="p-2 text-gray-400 hover:text-gray-600 transition-colors"
                      title="View Details"
                    >
                      <EyeIcon className="h-5 w-5" />
                    </button>
                    {order.boostStatus === 'ACTIVE' && (
                      <button
                        onClick={() => handleDeleteOrder(order.id!)}
                        disabled={deletingOrder === order.id}
                        className="p-2 text-red-400 hover:text-red-600 transition-colors disabled:opacity-50"
                        title="Delete Order"
                      >
                        {deletingOrder === order.id ? (
                          <div className="animate-spin rounded-full h-5 w-5 border-b-2 border-red-600"></div>
                        ) : (
                          <TrashIcon className="h-5 w-5" />
                        )}
                      </button>
                    )}
                  </div>
                </div>

                {/* Progress indicator for taken orders */}
                {order.boostStatus === 'TAKEN' && (
                  <div className="mt-4">
                    <div className="flex items-center justify-between text-sm text-gray-600 mb-2">
                      <span>Progress</span>
                      <span>In Progress</span>
                    </div>
                    <div className="w-full bg-gray-200 rounded-full h-2">
                      <div className="bg-primary-600 h-2 rounded-full animate-pulse" style={{ width: '60%' }}></div>
                    </div>
                  </div>
                )}
              </div>
            ))}
          </div>
        )}
      </div>

      {/* Stats Section */}
      <div className="bg-white border-t border-gray-200">
        <div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8 py-8">
          <div className="grid grid-cols-1 md:grid-cols-4 gap-6">
            <div className="text-center">
              <div className="text-2xl font-bold text-primary-600">
                {displayOrders.filter(o => o.boostStatus === 'ACTIVE').length}
              </div>
              <div className="text-sm text-gray-500">Active Orders</div>
            </div>
            <div className="text-center">
              <div className="text-2xl font-bold text-blue-600">
                {displayOrders.filter(o => o.boostStatus === 'TAKEN').length}
              </div>
              <div className="text-sm text-gray-500">In Progress</div>
            </div>
            <div className="text-center">
              <div className="text-2xl font-bold text-green-600">
                {displayOrders.filter(o => o.boostStatus === 'COMPLETED').length}
              </div>
              <div className="text-sm text-gray-500">Completed</div>
            </div>
            <div className="text-center">
              <div className="text-2xl font-bold text-red-600">
                {displayOrders.filter(o => o.boostStatus === 'CANCELLED').length}
              </div>
              <div className="text-sm text-gray-500">Cancelled</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Orders;
