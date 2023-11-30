{{/* Define a helper to generate the full MySQL connection URL */}}
{{- define "my-spring-app.fullMySQLConnectionURL" -}}
jdbc:mysql://{{ .Release.Name }}-mysql-service:3306/{{ .Values.mysql.databaseName }}?createDatabaseIfNotExist=true&characterEncoding=UTF-8&useUnicode=true&useSSL=false&allowPublicKeyRetrieval=true
{{- end -}}
