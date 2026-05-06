export interface LoginRequest {
  username: string;
  password: string;
}

export interface AuthResponse {
  accessToken: string;
  tokenType: string;
  username: string;
  roles: string[];
  expiresIn: number;
}

export interface AppUser {
  id: number;
  userId: string;
  username: string;
  email: string;
  roles: AppRole[];
}

export interface AppRole {
  id: number;
  roleName: string;
}

export interface ChangePasswordRequest {
  oldPassword: string;
  newPassword: string;
  confirmPassword: string;
}
