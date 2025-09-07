ALTER TABLE app_user
  ADD COLUMN status varchar(20) NOT NULL DEFAULT 'ACTIVE';

CREATE INDEX IF NOT EXISTS idx_app_user_status ON app_user(status);
