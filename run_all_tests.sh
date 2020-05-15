#!/bin/bash
current_dir=$PWD;
for line in `find . -name 'gradlew'`
do
  cd $current_dir;
  echo "will run tests for ${line}";
  cd $(dirname "${line}");
  pwd
  if [["${line}" == "./practico02-kotlin-testing/gradlew"]]
  then
    ./gradlew --no-daemon clean test cC
  else
    ./gradlew --no-daemon clean test cC -x :app:connectedDebugAndroidTest
  fi
  if [ $? -eq 0 ]
  then
    echo "tests for ${line} are successful"
  else
    echo "tests for ${line} FAILED"
    exit 1
  fi
done
