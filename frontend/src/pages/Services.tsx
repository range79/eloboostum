import React, { useState, useEffect } from 'react';
import { 
  StarIcon, 
  ClockIcon, 
  ShieldCheckIcon,
  TrophyIcon,
  CheckCircleIcon
} from '@heroicons/react/24/outline';
import { servicesAPI, userOrdersAPI } from '../services/api';
import { Service } from '../types';
import { useAuth } from '../contexts/AuthContext';

const Services: React.FC = () => {
  const [services, setServices] = useState<Service[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [requestingBoost, setRequestingBoost] = useState<number | null>(null);
  const { isAuthenticated } = useAuth();

  useEffect(() => {
    fetchServices();
  }, []);

  const fetchServices = async () => {
    try {
      setLoading(true);
      const response = await servicesAPI.getAllServices();
      setServices(response.content);
    } catch (err: any) {
      setError('Failed to load services. Please try again.');
    } finally {
      setLoading(false);
    }
  };

  const handleRequestBoost = async (serviceId: number) => {
    if (!isAuthenticated) {
      // Redirect to login or show login modal
      return;
    }

    try {
      setRequestingBoost(serviceId);
      await userOrdersAPI.requestBoost(serviceId);
      // Show success message or redirect to orders page
      alert('Boost request submitted successfully!');
    } catch (err: any) {
      alert(err.response?.data?.message || 'Failed to request boost. Please try again.');
    } finally {
      setRequestingBoost(null);
    }
  };

  // Mock services data for demonstration
  const mockServices: Service[] = [
    {
      id: 1,
      name: 'Bronze to Silver',
      description: 'Professional boost from Bronze to Silver rank. Fast and secure service with experienced boosters.',
      coverImageURL: 'https://via.placeholder.com/400x200/3B82F6/FFFFFF?text=Bronze+to+Silver',
      isActive: true,
      createdAt: new Date().toISOString(),
      updatedAt: new Date().toISOString(),
    },
    {
      id: 2,
      name: 'Silver to Gold',
      description: 'Climb from Silver to Gold with our professional boosters. Guaranteed satisfaction and fast delivery.',
      coverImageURL: 'https://via.placeholder.com/400x200/10B981/FFFFFF?text=Silver+to+Gold',
      isActive: true,
      createdAt: new Date().toISOString(),
      updatedAt: new Date().toISOString(),
    },
    {
      id: 3,
      name: 'Gold to Platinum',
      description: 'Advanced boosting service from Gold to Platinum. High-level players with excellent win rates.',
      coverImageURL: 'https://via.placeholder.com/400x200/F59E0B/FFFFFF?text=Gold+to+Platinum',
      isActive: true,
      createdAt: new Date().toISOString(),
      updatedAt: new Date().toISOString(),
    },
    {
      id: 4,
      name: 'Platinum to Diamond',
      description: 'Elite boosting service for Platinum to Diamond. Top-tier players with competitive experience.',
      coverImageURL: 'https://via.placeholder.com/400x200/8B5CF6/FFFFFF?text=Platinum+to+Diamond',
      isActive: true,
      createdAt: new Date().toISOString(),
      updatedAt: new Date().toISOString(),
    },
  ];

  const displayServices = services.length > 0 ? services : mockServices;

  if (loading) {
    return (
      <div className="min-h-screen flex items-center justify-center">
        <div className="animate-spin rounded-full h-32 w-32 border-b-2 border-primary-600"></div>
      </div>
    );
  }

  return (
    <div className="bg-gray-50 min-h-screen">
      {/* Hero Section */}
      <div className="bg-white">
        <div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8 py-24">
          <div className="text-center">
            <h1 className="text-4xl font-bold tracking-tight text-gray-900 sm:text-6xl">
              Choose Your{' '}
              <span className="text-primary-600">Boost Service</span>
            </h1>
            <p className="mt-6 text-lg leading-8 text-gray-600 max-w-2xl mx-auto">
              Select from our range of professional League of Legends boosting services. 
              Fast, secure, and reliable service to help you reach your desired rank.
            </p>
          </div>
        </div>
      </div>

      {/* Services Grid */}
      <div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8 py-16">
        {error && (
          <div className="mb-8 rounded-md bg-red-50 p-4">
            <div className="flex">
              <div className="ml-3">
                <h3 className="text-sm font-medium text-red-800">{error}</h3>
              </div>
            </div>
          </div>
        )}

        <div className="grid grid-cols-1 gap-8 md:grid-cols-2 lg:grid-cols-2">
          {displayServices.map((service) => (
            <div key={service.id} className="card hover:shadow-lg transition-shadow duration-300">
              <div className="aspect-w-16 aspect-h-9 mb-6">
                <img
                  src={service.coverImageURL || `https://via.placeholder.com/400x200/3B82F6/FFFFFF?text=${service.name}`}
                  alt={service.name}
                  className="w-full h-48 object-cover rounded-lg"
                />
              </div>
              
              <div className="space-y-4">
                <div>
                  <h3 className="text-xl font-semibold text-gray-900 mb-2">
                    {service.name}
                  </h3>
                  <p className="text-gray-600">
                    {service.description}
                  </p>
                </div>

                {/* Features */}
                <div className="space-y-2">
                  <div className="flex items-center text-sm text-gray-600">
                    <CheckCircleIcon className="h-4 w-4 text-green-500 mr-2" />
                    Professional boosters
                  </div>
                  <div className="flex items-center text-sm text-gray-600">
                    <CheckCircleIcon className="h-4 w-4 text-green-500 mr-2" />
                    Secure account handling
                  </div>
                  <div className="flex items-center text-sm text-gray-600">
                    <CheckCircleIcon className="h-4 w-4 text-green-500 mr-2" />
                    Fast delivery
                  </div>
                  <div className="flex items-center text-sm text-gray-600">
                    <CheckCircleIcon className="h-4 w-4 text-green-500 mr-2" />
                    24/7 support
                  </div>
                </div>

                {/* Stats */}
                <div className="flex items-center justify-between text-sm text-gray-500">
                  <div className="flex items-center">
                    <StarIcon className="h-4 w-4 text-yellow-400 mr-1" />
                    <span>4.9/5 rating</span>
                  </div>
                  <div className="flex items-center">
                    <ClockIcon className="h-4 w-4 mr-1" />
                    <span>2-5 days</span>
                  </div>
                </div>

                {/* Action Button */}
                <button
                  onClick={() => handleRequestBoost(service.id!)}
                  disabled={requestingBoost === service.id || !service.isActive}
                  className="w-full btn-primary disabled:opacity-50 disabled:cursor-not-allowed"
                >
                  {requestingBoost === service.id ? (
                    <div className="flex items-center justify-center">
                      <div className="animate-spin rounded-full h-4 w-4 border-b-2 border-white mr-2"></div>
                      Requesting...
                    </div>
                  ) : (
                    'Request Boost'
                  )}
                </button>
              </div>
            </div>
          ))}
        </div>

        {/* Why Choose Us Section */}
        <div className="mt-24">
          <div className="text-center mb-12">
            <h2 className="text-3xl font-bold text-gray-900 mb-4">
              Why Choose Our Boosting Service?
            </h2>
            <p className="text-lg text-gray-600 max-w-2xl mx-auto">
              We provide the best League of Legends boosting experience with professional players and excellent customer support.
            </p>
          </div>

          <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
            <div className="text-center">
              <div className="mx-auto h-12 w-12 bg-primary-100 rounded-lg flex items-center justify-center mb-4">
                <TrophyIcon className="h-6 w-6 text-primary-600" />
              </div>
              <h3 className="text-lg font-semibold text-gray-900 mb-2">Professional Boosters</h3>
              <p className="text-gray-600">
                Our team consists of high-ranked players with years of competitive experience.
              </p>
            </div>
            <div className="text-center">
              <div className="mx-auto h-12 w-12 bg-primary-100 rounded-lg flex items-center justify-center mb-4">
                <ShieldCheckIcon className="h-6 w-6 text-primary-600" />
              </div>
              <h3 className="text-lg font-semibold text-gray-900 mb-2">Secure & Safe</h3>
              <p className="text-gray-600">
                Your account security is our top priority. We use VPNs and follow strict protocols.
              </p>
            </div>
            <div className="text-center">
              <div className="mx-auto h-12 w-12 bg-primary-100 rounded-lg flex items-center justify-center mb-4">
                <ClockIcon className="h-6 w-6 text-primary-600" />
              </div>
              <h3 className="text-lg font-semibold text-gray-900 mb-2">Fast Delivery</h3>
              <p className="text-gray-600">
                Get your boost completed quickly with our efficient service and real-time updates.
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Services;
