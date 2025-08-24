# EloBoost Frontend

A beautiful, modern React frontend for the EloBoost League of Legends boosting service platform.

## Features

- 🎨 **Modern UI/UX**: Beautiful, responsive design with Tailwind CSS
- 🔐 **Authentication**: Secure login/register system with JWT tokens
- 📱 **Responsive Design**: Works perfectly on desktop, tablet, and mobile
- 🚀 **Fast Performance**: Optimized React components with TypeScript
- 🎯 **Role-based Access**: Different dashboards for users, boosters, and admins
- 📊 **Real-time Updates**: Live order tracking and status updates
- 🎨 **Beautiful Components**: Modern UI components with smooth animations

## Pages

- **Home**: Landing page with hero section and features
- **Services**: Browse and request boost services
- **Orders**: Track your boost orders and their status
- **Booster Dashboard**: Manage boost orders (for boosters)
- **Login/Register**: Authentication pages

## Tech Stack

- **React 18** with TypeScript
- **Tailwind CSS** for styling
- **React Router** for navigation
- **Axios** for API communication
- **Headless UI** for accessible components
- **Heroicons** for beautiful icons

## Getting Started

### Prerequisites

- Node.js 16+ 
- npm or yarn

### Installation

1. Navigate to the frontend directory:
```bash
cd frontend
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
npm start
```

The app will open at `http://localhost:3000`

### Building for Production

```bash
npm run build
```

## Project Structure

```
frontend/
├── public/                 # Static files
├── src/
│   ├── components/         # Reusable components
│   │   └── Layout/        # Layout components
│   ├── contexts/          # React contexts
│   ├── pages/             # Page components
│   ├── services/          # API services
│   ├── types/             # TypeScript type definitions
│   ├── App.tsx           # Main app component
│   ├── index.tsx         # Entry point
│   └── index.css         # Global styles
├── package.json
├── tailwind.config.js
└── README.md
```

## API Integration

The frontend integrates with the EloBoost backend API:

- **Authentication**: `/api/v1/auth/login`, `/api/v1/auth/register`
- **Services**: `/api/v1/services/*`
- **User Orders**: `/api/v1/user/orders/*`
- **Booster Orders**: `/api/v1/boost-orders/*`

## Features in Detail

### Authentication
- JWT token-based authentication
- Automatic token refresh
- Protected routes
- Role-based access control

### Services Page
- Browse available boost services
- Request boosts with one click
- Beautiful service cards with descriptions
- Real-time availability status

### Orders Management
- Track order status in real-time
- Delete pending orders
- View order history
- Progress indicators for active orders

### Booster Dashboard
- View available boost requests
- Accept/cancel boost orders
- Track progress of active boosts
- Statistics and performance metrics

## Styling

The app uses Tailwind CSS with a custom color scheme:

- **Primary**: Blue gradient (`primary-600` to `primary-800`)
- **Secondary**: Gray scale for text and backgrounds
- **Status Colors**: 
  - Active: Yellow
  - In Progress: Blue
  - Completed: Green
  - Cancelled: Red

## Responsive Design

The app is fully responsive with breakpoints:
- **Mobile**: < 640px
- **Tablet**: 640px - 1024px
- **Desktop**: > 1024px

## Browser Support

- Chrome (latest)
- Firefox (latest)
- Safari (latest)
- Edge (latest)

## Development

### Available Scripts

- `npm start` - Start development server
- `npm build` - Build for production
- `npm test` - Run tests
- `npm eject` - Eject from Create React App

### Code Style

- TypeScript for type safety
- ESLint for code linting
- Prettier for code formatting
- Component-based architecture

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## License

This project is part of the EloBoost platform.
