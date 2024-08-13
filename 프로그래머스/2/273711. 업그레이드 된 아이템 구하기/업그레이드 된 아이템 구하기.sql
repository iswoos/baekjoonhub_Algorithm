SELECT 
    info.ITEM_ID, info.ITEM_NAME, info.RARITY
FROM 
    ITEM_INFO AS info
JOIN 
    ITEM_TREE AS tree
ON 
    info.ITEM_ID = tree.ITEM_ID
WHERE tree.PARENT_ITEM_ID IN (
    SELECT 
        ITEM_ID
    FROM 
        ITEM_INFO
    WHERE 
        RARITY = 'RARE'
    ) 
ORDER BY 
    info.ITEM_ID DESC;