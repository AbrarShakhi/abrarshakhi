-- Keymaps are automatically loaded on the VeryLazy event
-- Default keymaps that are always set: https://github.com/LazyVim/LazyVim/blob/main/lua/lazyvim/config/keymaps.lua
-- Add any additional keymaps here

local km = vim.keymap

-- copy line down alt+shift+j
km.set("i", "<M-J>", "<Esc>:t-<CR>==gi")
km.set("n", "<M-J>", "<Esc>:t-<CR>")
km.set("v", "<M-J>", "<Esc>:t-<CR>==gv")

km.set("i", "<M-BS>", "<C-w>", { desc = "delete word left with alt+backspace" })

-- delete line alt+shift+l
km.set("i", "<M-L>", '<C-o>"_dd')
km.set("n", "<M-L>", '"_dd')
