echo "# indie-game" >> README.md
git init
git add README.md
git commit -m "%date:~-4%_%date:~3,2%_%date:~0,2%__%time:~0,2%_%time:~3,2%_%time:~6,2%"
git remote add origin https://github.com/Unlimited2112/indie-game.git
git push -u origin master