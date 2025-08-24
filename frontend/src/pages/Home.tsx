import React from 'react';
import { Link } from 'react-router-dom';
import { 
  TrophyIcon, 
  ShieldCheckIcon, 
  ClockIcon, 
  UserGroupIcon,
  StarIcon,
  ChartBarIcon
} from '@heroicons/react/24/outline';

const Home: React.FC = () => {
  const features = [
    {
      name: 'Professional Boosters',
      description: 'Our team consists of high-ranked players with years of experience in competitive play.',
      icon: TrophyIcon,
    },
    {
      name: 'Secure & Safe',
      description: 'Your account security is our top priority. We use VPNs and follow strict security protocols.',
      icon: ShieldCheckIcon,
    },
    {
      name: 'Fast Delivery',
      description: 'Get your boost completed quickly with our efficient service and real-time updates.',
      icon: ClockIcon,
    },
    {
      name: '24/7 Support',
      description: 'Our customer support team is available around the clock to assist you.',
      icon: UserGroupIcon,
    },
    {
      name: 'Quality Guarantee',
      description: 'We guarantee satisfaction with our service or your money back.',
      icon: StarIcon,
    },
    {
      name: 'Progress Tracking',
      description: 'Track your boost progress in real-time through our dashboard.',
      icon: ChartBarIcon,
    },
  ];

  const stats = [
    { name: 'Happy Customers', value: '10,000+' },
    { name: 'Completed Boosts', value: '50,000+' },
    { name: 'Average Rating', value: '4.9/5' },
    { name: 'Years Experience', value: '5+' },
  ];

  return (
    <div className="bg-white">
      {/* Hero section */}
      <div className="relative isolate px-6 pt-14 lg:px-8">
        <div className="absolute inset-x-0 -top-40 -z-10 transform-gpu overflow-hidden blur-3xl sm:-top-80">
          <div
            className="relative left-[calc(50%-11rem)] aspect-[1155/678] w-[36.125rem] -translate-x-1/2 rotate-[30deg] bg-gradient-to-tr from-primary-600 to-primary-800 opacity-30 sm:left-[calc(50%-30rem)] sm:w-[72.1875rem]"
            style={{
              clipPath:
                'polygon(74.1% 44.1%, 100% 61.6%, 97.5% 26.9%, 85.5% 0.1%, 80.7% 2%, 72.5% 32.5%, 60.2% 62.4%, 52.4% 68.1%, 47.5% 58.3%, 45.2% 34.5%, 27.5% 76.7%, 0.1% 64.9%, 17.9% 100%, 27.6% 76.8%, 76.1% 97.7%, 74.1% 44.1%)',
            }}
          />
        </div>
        <div className="mx-auto max-w-2xl py-32 sm:py-48 lg:py-56">
          <div className="text-center">
            <h1 className="text-4xl font-bold tracking-tight text-gray-900 sm:text-6xl">
              Professional{' '}
              <span className="text-primary-600">League of Legends</span>{' '}
              Boosting Service
            </h1>
            <p className="mt-6 text-lg leading-8 text-gray-600">
              Climb the ranked ladder with our professional boosters. Fast, secure, and reliable service to help you reach your desired rank.
            </p>
            <div className="mt-10 flex items-center justify-center gap-x-6">
              <Link
                to="/services"
                className="btn-primary text-lg px-8 py-3"
              >
                View Services
              </Link>
              <Link
                to="/register"
                className="text-lg font-semibold leading-6 text-gray-900 hover:text-primary-600"
              >
                Learn more <span aria-hidden="true">→</span>
              </Link>
            </div>
          </div>
        </div>
        <div className="absolute inset-x-0 top-[calc(100%-13rem)] -z-10 transform-gpu overflow-hidden blur-3xl sm:top-[calc(100%-30rem)]">
          <div
            className="relative left-[calc(50%+3rem)] aspect-[1155/678] w-[36.125rem] -translate-x-1/2 bg-gradient-to-tr from-primary-600 to-primary-800 opacity-30 sm:left-[calc(50%+36rem)] sm:w-[72.1875rem]"
            style={{
              clipPath:
                'polygon(74.1% 44.1%, 100% 61.6%, 97.5% 26.9%, 85.5% 0.1%, 80.7% 2%, 72.5% 32.5%, 60.2% 62.4%, 52.4% 68.1%, 47.5% 58.3%, 45.2% 34.5%, 27.5% 76.7%, 0.1% 64.9%, 17.9% 100%, 27.6% 76.8%, 76.1% 97.7%, 74.1% 44.1%)',
            }}
          />
        </div>
      </div>

      {/* Stats section */}
      <div className="bg-gray-50 py-24 sm:py-32">
        <div className="mx-auto max-w-7xl px-6 lg:px-8">
          <dl className="grid grid-cols-1 gap-x-8 gap-y-16 text-center lg:grid-cols-4">
            {stats.map((stat) => (
              <div key={stat.name} className="mx-auto flex max-w-xs flex-col gap-y-4">
                <dt className="text-base leading-7 text-gray-600">{stat.name}</dt>
                <dd className="order-first text-3xl font-semibold tracking-tight text-primary-600 sm:text-5xl">
                  {stat.value}
                </dd>
              </div>
            ))}
          </dl>
        </div>
      </div>

      {/* Features section */}
      <div className="py-24 sm:py-32">
        <div className="mx-auto max-w-7xl px-6 lg:px-8">
          <div className="mx-auto max-w-2xl lg:text-center">
            <h2 className="text-base font-semibold leading-7 text-primary-600">Why Choose Us</h2>
            <p className="mt-2 text-3xl font-bold tracking-tight text-gray-900 sm:text-4xl">
              Everything you need for a successful boost
            </p>
            <p className="mt-6 text-lg leading-8 text-gray-600">
              We provide the best League of Legends boosting service with professional players, secure handling, and excellent customer support.
            </p>
          </div>
          <div className="mx-auto mt-16 max-w-2xl sm:mt-20 lg:mt-24 lg:max-w-4xl">
            <dl className="grid max-w-xl grid-cols-1 gap-x-8 gap-y-10 lg:max-w-none lg:grid-cols-2 lg:gap-y-16">
              {features.map((feature) => (
                <div key={feature.name} className="relative pl-16">
                  <dt className="text-base font-semibold leading-7 text-gray-900">
                    <div className="absolute left-0 top-0 flex h-10 w-10 items-center justify-center rounded-lg bg-primary-600">
                      <feature.icon className="h-6 w-6 text-white" aria-hidden="true" />
                    </div>
                    {feature.name}
                  </dt>
                  <dd className="mt-2 text-base leading-7 text-gray-600">{feature.description}</dd>
                </div>
              ))}
            </dl>
          </div>
        </div>
      </div>

      {/* CTA section */}
      <div className="bg-primary-600">
        <div className="px-6 py-24 sm:px-6 sm:py-32 lg:px-8">
          <div className="mx-auto max-w-2xl text-center">
            <h2 className="text-3xl font-bold tracking-tight text-white sm:text-4xl">
              Ready to climb the ladder?
              <br />
              Start your boost today.
            </h2>
            <p className="mx-auto mt-6 max-w-xl text-lg leading-8 text-primary-200">
              Join thousands of satisfied customers who have reached their desired rank with our professional boosting service.
            </p>
            <div className="mt-10 flex items-center justify-center gap-x-6">
              <Link
                to="/services"
                className="rounded-md bg-white px-3.5 py-2.5 text-sm font-semibold text-primary-600 shadow-sm hover:bg-primary-50 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-white"
              >
                Get started
              </Link>
              <Link
                to="/register"
                className="text-sm font-semibold leading-6 text-white"
              >
                Learn more <span aria-hidden="true">→</span>
              </Link>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;
