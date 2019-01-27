interface MenuItem {
  icon: string;
  title: string;
  route: string;
}

export const MENU: MenuItem[] = [
  {
    icon: 'dashboard',
    title: 'Dashboard',
    route: '/pages/dashboard',
  },
  {
    icon: 'device_hub',
    title: 'Devices',
    route: '/pages/device',
  },
];
