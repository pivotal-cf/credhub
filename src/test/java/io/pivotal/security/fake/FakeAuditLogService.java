package io.pivotal.security.fake;

import io.pivotal.security.service.AuditLogService;
import io.pivotal.security.service.AuditRecordParameters;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@SuppressWarnings("unused")
@Component
@Primary
@ConditionalOnExpression("#{!environment.getProperty('spring.profiles.active').contains('ControllerAuditLogTest')}")
public class FakeAuditLogService implements AuditLogService {

  @Override
  public ResponseEntity<?> performWithAuditing(AuditRecordParameters auditRecordParameters, Supplier<ResponseEntity<?>> action) throws Exception {
    return action.get();
  }
}
