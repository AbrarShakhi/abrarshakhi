#!/usr/bin/sh

# git branch -M main
# git remote add origin https://github.com/AbrarShakhi/abrarshakhi.git
# git push -u origin main

dirs=(
	"README.md"
	".gitadd.sh"
	# env
	".zshrc"
	".config/sh"
  ".zshenv"
	# editor
	".config/nvim"
	".config/helix"
	# terminal emulator
	".config/kitty"
	# window manager and utils
	".config/rofi"
	".config/awesome/"
)

for dir in "${dirs[@]}"; do
	git add "$dir"
done

echo "Directories have been added to the git staging area."

git status
