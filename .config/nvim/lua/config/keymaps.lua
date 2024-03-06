-- Keymaps are automatically loaded on the VeryLazy event
-- Default keymaps that are always set: https://github.com/LazyVim/LazyVim/blob/main/lua/lazyvim/config/keymaps.lua
-- Add any additional keymaps here

local km = vim.keymap

-- copy line down alt+shift+j
km.set("i", "<M-J>", "<Esc>:t-<CR>==gi", { desc = "copy line down" })
km.set("n", "<M-J>", "<Esc>:t-<CR>", { desc = "copy line down" })
km.set("v", "<M-J>", "<Esc>:t-<CR>==gv", { desc = "copy line down" })

km.set("i", "<M-BS>", "<C-w>", { desc = "delete word left with alt+backspace" })

-- delete line alt+shift+l
km.set("i", "<M-L>", '<C-o>"_dd', { desc = "delet a line" })
km.set("n", "<M-L>", '"_dd', { desc = "delet a line" })

km.set("n", "<leader>acp", "<C-o>:%y+<CR>", { desc = "Copy the entire file" })
