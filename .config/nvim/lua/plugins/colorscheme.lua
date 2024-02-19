return {
    {
        'navarasu/onedark.nvim',
        -- priority = 1000,
        lazy = true,
        -- config = function()
            -- require('onedark').setup {
                -- Set a style preset. 'dark' is default.
                -- style = 'warmer', -- dark, darker, cool, deep, warm, warmer, light
            -- }
        -- require('onedark').load()
        --- end
    },
    {
        "ellisonleao/gruvbox.nvim",
        -- priority = 1000,
        -- config = function()
            -- require('gruvbox').setup {
                -- Set a style preset. 'dark' is default.
                -- style = 'dark', -- dark, darker, cool, deep, warm, warmer, light
            -- }
            -- require('gruvbox').load()
        -- end,
        lazy = true,
        -- opts = {}
    },
    {
        "sainnhe/sonokai",
        priority = 1000,
        config = function()
            vim.cmd(":colorscheme sonokai")
        end,
        lazy = false,
        opts = {}
    }
}
