package icici.common.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import icici.business.BusinessException;
import icici.business.UserService;
import icici.business.model.User;

public class UserDetailsServiceImpl implements UserDetailsService {
  
   
   @Autowired
   private UserService userService;

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user;
      try {
         user = userService.findByUsername(username);
      } catch (BusinessException e) {
         throw new UsernameNotFoundException("User not found.");
      }

      if (user == null) {
         throw new UsernameNotFoundException("User not found.");
      }

      return new UserDetailsImpl(user);
   }
   
   

}
