echo 'build js resources'
npm run build --prefix ./web

echo 'clear java resources'
./gradlew cleanResourcesTask

echo 'copy to java dir from js dir'
./gradlew copyTask