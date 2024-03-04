#!/usr/bin/sh

# git branch -M main
# git remote add origin https://github.com/AbrarShakhi/abrarshakhi.git
# git push -u origin main

dirs=(
	"README.md"
	".gitadd.sh"
	# env
	".zshrc"
  ".zshenv"
	# editor
	".config/nvim"
	".config/helix"
	".emacs"
	# terminal emulator
	".config/kitty"
	# window manager
	".config/hypr"
	".config/awesome"
)

for dir in "${dirs[@]}"; do
	git add "$dir"
done

echo "Directories have been added to the git staging area."
