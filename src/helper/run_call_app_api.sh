#!/bin/bash
# author: cesar.alcancio@gmail.com
while true
do
  curl -XGET 'http://localhost:8080/'
  curl -XGET 'http://localhost:8080/berlin/contributors'
  curl -XGET 'http://localhost:8080/loans/contributors'
  curl -XGET 'http://localhost:8080/berlin/random-contributor'
done