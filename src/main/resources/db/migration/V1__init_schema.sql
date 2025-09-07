create table if not exists app_user (
  id          bigserial primary key,
  email       varchar(255) not null unique,
  name        varchar(100),
  created_at  timestamptz  not null default now()
);