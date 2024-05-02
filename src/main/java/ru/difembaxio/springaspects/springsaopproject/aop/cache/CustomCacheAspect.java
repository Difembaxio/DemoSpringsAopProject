package ru.difembaxio.springaspects.springsaopproject.aop.cache;


import jakarta.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.difembaxio.springaspects.springsaopproject.utils.CustomCacheable;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class CustomCacheAspect {

  private Map<Object, Object> cacheMap = new HashMap<>();

  @Around("@annotation(customCacheable)")
  public Object addCache(ProceedingJoinPoint joinPoint, CustomCacheable customCacheable) {
    Object[] args = joinPoint.getArgs();
    Object key = args[0];
    log.info("Метод addCache вызван с ключом: {}", key);
    Object cachedObject = cacheMap.get(key);
    if (cachedObject != null) {
      log.info("Результат для ключа {} взят из кэша", key);
      return cachedObject;
    } else {
      try {
        Object result = joinPoint.proceed();
        log.info("Результат для ключа {} добавлен в кэш", key);
        cacheMap.put(key, result);
        log.info("В кэш попал объект: {}", result);
        return result;
      } catch (EntityNotFoundException e) {
        log.warn("Исключение EntityNotFoundException: {}", e.getMessage());
        return null;
      } catch (Throwable e) {
        throw new RuntimeException(e);
      }
    }
  }
}
