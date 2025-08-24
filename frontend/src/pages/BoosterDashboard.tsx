import React, { useState, useEffect } from 'react';
import { 
  ClockIcon, 
  CheckCircleIcon, 
  XCircleIcon,
  ExclamationTriangleIcon,
  UserIcon,
  TrophyIcon,
  CheckIcon,
  XMarkIcon
} from '@heroicons/react/24/outline';
import { boosterOrdersAPI } from '../services/api';
import { BoostOrder } from '../types';

const BoosterDashboard: React.FC = () => {
  const [orders, setOrders] = useState<BoostOrder[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [processingOrder, setProcessingOrder] = useState<number | null>(null);

  useEffect(() => {
    fetchOrders();
  }, []);

  const fetchOrders = async () => {
    try {
      setLoading(true);
      const response = await boosterOrdersAPI.getMyBoosts();
      setOrders(response.content);
    } catch (err: any) {
      setError('Failed to load orders. Please try again.');
    } finally {
      setLoading(false);
    }
  };

  const handleAcceptBoost = async (boostId: number) => {
    try {
      setProcessingOrder(boostId);
      await boosterOrdersAPI.acceptBoost(boostId);
      // Refresh orders
      await fetchOrders();
      alert('Boost accepted successfully!');
    } catch (err: any) {
      alert(err.response?.data?.message || 'Failed to accept boost. Please try again.');
    } finally {
      setProcessingOrder(null);
    }
  };

  const handleCancelBoost = async (boostId: number) => {
    if (!window.confirm('Are you sure you want to cancel this boost?')) {
      return;
    }

    try {
      setProcessingOrder(boostId);
      await boosterOrdersAPI.cancelBoost(boostId);
      // Refresh orders
      await fetchOrders();
      alert('Boost cancelled successfully!');
    } catch (err: any) {
      alert(err.response?.data?.message || 'Failed to cancel boost. Please try again.');
    } finally {
      setProcessingOrder(null);
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
        return 'Available';
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
      createdAt: new Date(Date.now() - 3600000).toISOString(), // 1 hour ago
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
      userId: 2,
      serviceId: 2,
      boosterId: 1,
      boostStatus: 'TAKEN',
      createdAt: new Date(Date.now() - 86400000).toISOString(), // 1 day ago
      acceptedAt: new Date(Date.now() - 43200000).toISOString(),
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
      userId: 3,
      serviceId: 3,
      boosterId: 1,
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

  const stats = [
    {
      name: 'Total Orders',
      value: displayOrders.length,
      icon: TrophyIcon,
      color: 'text-primary-600',
    },
    {
      name: 'Active Orders',
      value: displayOrders.filter(o => o.boostStatus === 'ACTIVE').length,
      icon: ClockIcon,
      color: 'text-yellow-600',
    },
    {
      name: 'In Progress',
      value: displayOrders.filter(o => o.boostStatus === 'TAKEN').length,
      icon: ExclamationTriangleIcon,
      color: 'text-blue-600',
    },
    {
      name: 'Completed',
      value: displayOrders.filter(o => o.boostStatus === 'COMPLETED').length,
      icon: CheckCircleIcon,
      color: 'text-green-600',
    },
  ];

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
              <h1 className="text-3xl font-bold text-gray-900">Booster Dashboard</h1>
              <p className="mt-2 text-gray-600">
                Manage your boost orders and track your progress
              </p>
            </div>
            <div className="flex items-center space-x-4">
              <div className="text-right">
                <p className="text-sm text-gray-500">Welcome back,</p>
                <p className="text-lg font-semibold text-gray-900">Professional Booster</p>
              </div>
              <div className="h-10 w-10 bg-primary-100 rounded-full flex items-center justify-center">
                <UserIcon className="h-6 w-6 text-primary-600" />
              </div>
            </div>
          </div>
        </div>
      </div>

      {/* Stats */}
      <div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8 py-8">
        <div className="grid grid-cols-1 md:grid-cols-4 gap-6 mb-8">
          {stats.map((stat) => (
            <div key={stat.name} className="card">
              <div className="flex items-center">
                <div className={`p-2 rounded-lg bg-gray-100 ${stat.color}`}>
                  <stat.icon className="h-6 w-6" />
                </div>
                <div className="ml-4">
                  <p className="text-sm font-medium text-gray-600">{stat.name}</p>
                  <p className={`text-2xl font-bold ${stat.color}`}>{stat.value}</p>
                </div>
              </div>
            </div>
          ))}
        </div>

        {error && (
          <div className="mb-8 rounded-md bg-red-50 p-4">
            <div className="flex">
              <div className="ml-3">
                <h3 className="text-sm font-medium text-red-800">{error}</h3>
              </div>
            </div>
          </div>
        )}

        {/* Orders */}
        <div className="space-y-6">
          <div className="flex items-center justify-between">
            <h2 className="text-xl font-semibold text-gray-900">Available Orders</h2>
            <button
              onClick={fetchOrders}
              className="text-primary-600 hover:text-primary-700 text-sm font-medium"
            >
              Refresh
            </button>
          </div>

          {displayOrders.length === 0 ? (
            <div className="text-center py-12">
              <div className="mx-auto h-12 w-12 text-gray-400">
                <ClockIcon className="h-12 w-12" />
              </div>
              <h3 className="mt-2 text-sm font-medium text-gray-900">No orders available</h3>
              <p className="mt-1 text-sm text-gray-500">
                Check back later for new boost requests.
              </p>
            </div>
          ) : (
            <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
              {displayOrders.map((order) => (
                <div key={order.id} className="card">
                  <div className="flex items-start justify-between">
                    <div className="flex-1">
                      <div className="flex items-center space-x-3 mb-2">
                        <h3 className="text-lg font-medium text-gray-900">
                          {order.service?.name || `Service #${order.serviceId}`}
                        </h3>
                        <span className={`inline-flex items-center px-2.5 py-0.5 rounded-full text-xs font-medium ${getStatusColor(order.boostStatus)}`}>
                          {getStatusText(order.boostStatus)}
                        </span>
                      </div>
                      <p className="text-sm text-gray-600 mb-3">
                        {order.service?.description}
                      </p>
                      <div className="flex items-center space-x-4 text-sm text-gray-500">
                        <span>Order ID: #{order.id}</span>
                        <span>Created: {new Date(order.createdAt).toLocaleDateString()}</span>
                        {order.acceptedAt && (
                          <span>Started: {new Date(order.acceptedAt).toLocaleDateString()}</span>
                        )}
                      </div>
                    </div>
                    <div className="flex-shrink-0 ml-4">
                      {getStatusIcon(order.boostStatus)}
                    </div>
                  </div>

                  {/* Action buttons */}
                  <div className="mt-4 flex items-center space-x-2">
                    {order.boostStatus === 'ACTIVE' && (
                      <button
                        onClick={() => handleAcceptBoost(order.id!)}
                        disabled={processingOrder === order.id}
                        className="flex-1 btn-primary disabled:opacity-50"
                      >
                        {processingOrder === order.id ? (
                          <div className="flex items-center justify-center">
                            <div className="animate-spin rounded-full h-4 w-4 border-b-2 border-white mr-2"></div>
                            Accepting...
                          </div>
                        ) : (
                          <div className="flex items-center justify-center">
                            <CheckIcon className="h-4 w-4 mr-2" />
                            Accept Boost
                          </div>
                        )}
                      </button>
                    )}
                    {order.boostStatus === 'TAKEN' && (
                      <button
                        onClick={() => handleCancelBoost(order.id!)}
                        disabled={processingOrder === order.id}
                        className="flex-1 btn-danger disabled:opacity-50"
                      >
                        {processingOrder === order.id ? (
                          <div className="flex items-center justify-center">
                            <div className="animate-spin rounded-full h-4 w-4 border-b-2 border-white mr-2"></div>
                            Cancelling...
                          </div>
                        ) : (
                          <div className="flex items-center justify-center">
                            <XMarkIcon className="h-4 w-4 mr-2" />
                            Cancel Boost
                          </div>
                        )}
                      </button>
                    )}
                  </div>

                  {/* Progress indicator for taken orders */}
                  {order.boostStatus === 'TAKEN' && (
                    <div className="mt-4">
                      <div className="flex items-center justify-between text-sm text-gray-600 mb-2">
                        <span>Progress</span>
                        <span>In Progress</span>
                      </div>
                      <div className="w-full bg-gray-200 rounded-full h-2">
                        <div className="bg-primary-600 h-2 rounded-full animate-pulse" style={{ width: '75%' }}></div>
                      </div>
                    </div>
                  )}
                </div>
              ))}
            </div>
          )}
        </div>
      </div>
    </div>
  );
};

export default BoosterDashboard;
